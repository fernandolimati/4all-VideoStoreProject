package com.videostore.movie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.videostore.movie.model.*;
import com.videostore.movie.repository.DirectorRespository;
import com.videostore.movie.repository.MovieRentalRespository;
import com.videostore.movie.repository.MovieRespository;
import com.videostore.movie.repository.MovieStockRespository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieService {

    private final DirectorRespository directorRespository;
    private final MovieRespository movieRespository;
    private final MovieRentalRespository movieRentalRepository;
    private final MovieStockRespository movieStockRespository;

    public Director findDirectorByName(String directorName){
        return directorRespository.findByDirectorName(directorName);
    }

    public Movie createMovie(MovieJSON movieJSON){
        Movie movie = new Movie();
        Director director = findDirectorByName(movieJSON.getMovieDirector());

        if(director == null) {
            director = new Director();
            director.setDirectorName(movieJSON.getMovieDirector());
        }

        movie.setMovieTitle(movieJSON.getMovieTitle());
        movie.setDirector(director);
        return movieRespository.save(movie);
    }

    public Movie findMovieByTitle(String movieTitle){
        return movieRespository.findByMovieTitle(movieTitle);
    }

    public Iterable<Movie> findAllMovies(){
        return movieRespository.findAll();
    }

    public Iterable<MovieStock> findAvailableMovies(){
        return movieStockRespository.findAllByMovieTotalAvailableGreaterThan(0);
    }

    public MovieStock createMovieStock(MovieStockJSON movieStockJSON) {
        Optional<Movie> movie = movieRespository.findById(movieStockJSON.getMovieID());
        if(movie.isEmpty()) return null;
        MovieStock movieStock = new MovieStock();
        movieStock.setMovie(movie.get());
        movieStock.setMovieTotalAvailable(Long.valueOf(movieStockJSON.getMovieStockQtd()));
        movieStock.setMovieTotalAmount(Long.valueOf(movieStockJSON.getMovieStockQtd()));
        return movieStockRespository.save(movieStock);
    }

    public MovieRental rentMovie(MovieRentalJSON movieRentalJSON) {
        if(!findUserByEmail(movieRentalJSON.getUserEmail())) return null;
        MovieStock movieStock = movieStockRespository.findByMovie_IdAndAndMovieTotalAvailableGreaterThan(movieRentalJSON.getMovieID(),0);
        if(movieStock == null) return null;
        MovieRental movieRental = new MovieRental();
        movieRental.setMovieStock(movieStock);
        movieRental.setUserEmail(movieRentalJSON.getUserEmail());
        movieRental.setMovieRentalStatusEnum(MovieRentalStatusEnum.RENTED);
        movieRental.getMovieStock().setMovieTotalAmount(movieRental.getMovieStock().getMovieTotalAmount()-1);
        return movieRentalRepository.save(movieRental);
    }

    public MovieRental returnMovie(MovieRentalJSON movieRentalJSON){
        Iterable<MovieRental> movieRental = movieRentalRepository.findByUserEmailAndAndMovieRentalStatusEnumEquals(movieRentalJSON.getUserEmail(), MovieRentalStatusEnum.RENTED);
        if(IterableUtils.isEmpty(movieRental)) return null;
        for(MovieRental m:movieRental){
            if(m.getMovieStock().getMovie().getId().equalsIgnoreCase(movieRentalJSON.getMovieID())){
                m.getMovieStock().setMovieTotalAvailable(m.getMovieStock().getMovieTotalAvailable()+1);
                m.setMovieRentalStatusEnum(MovieRentalStatusEnum.RETURNED);
                return movieRentalRepository.save(m);
            }
        }
        return null;
    }



    private Boolean findUserByEmail(String userEmail){
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet requestGet = new HttpGet("http://localhost:7001/user/?emailUser="+userEmail);
            HttpResponse responseGet = httpClient.execute(requestGet);
            if(responseGet.getStatusLine().getStatusCode() == 200){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
