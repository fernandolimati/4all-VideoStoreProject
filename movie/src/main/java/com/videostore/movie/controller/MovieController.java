package com.videostore.movie.controller;

import com.videostore.movie.model.*;
import com.videostore.movie.service.MovieService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "Movie Service", description = "Version 1.0")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    @ApiOperation(value = "Return movie or movie´s in database with or without filter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movie(s) found"),
            @ApiResponse(code = 204, message = "Movie´s not found")
    })
    public ResponseEntity<?> getMovie(@ApiParam(value="Movie name to find (Optional)") @RequestParam("movieName") Optional<String> movieName){

        if(!movieName.isEmpty()){
            Movie movieDB = movieService.findMovieByTitle(movieName.get());
            if(movieDB != null) return new ResponseEntity<>(movieDB, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Iterable<Movie> movies = movieService.findAllMovies();
        if(movies == null || IterableUtils.size(movies) == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(movies,HttpStatus.OK);

    }

    @GetMapping(value = "/stock/available")
    @ApiOperation(value = "Return available movie´s in stock database with or without filter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movie(s) found"),
            @ApiResponse(code = 204, message = "Movie´s not found")
    })
    public ResponseEntity<?> getMovieAvailable(){
        Iterable<MovieStock> movies = movieService.findAvailableMovies();
        if(movies == null || IterableUtils.size(movies) == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }


    @PostMapping
    @ApiOperation(value = "Create movie in database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movie(s) found"),
            @ApiResponse(code = 204, message = "Movie´s not found")
    })
    public ResponseEntity<?> postCreateMovie(@ApiParam(value="JSON format with movie info", name = "Movie Information") @RequestBody MovieJSON movieJSON){
        Movie movie = movieService.createMovie(movieJSON);
        if(movie == null) return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @PostMapping(value = "/stock")
    @ApiOperation(value = "Create a movie stock in database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movie(s) found"),
            @ApiResponse(code = 204, message = "Movie´s not found")
    })
    public ResponseEntity<?> postCreateMovieStock(@ApiParam(value="JSON format with stock info", name = "Stock Information") @RequestBody MovieStockJSON movieStockJSON){
        MovieStock movieStock = movieService.createMovieStock(movieStockJSON);
        if(movieStock == null) return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(movieStock,HttpStatus.OK);
    }

    @PostMapping(value = "/rent")
    @ApiOperation(value = "Rent a movie")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movie(s) found"),
            @ApiResponse(code = 204, message = "Movie´s not found")
    })
    public ResponseEntity<?> postRentMovie(@ApiParam(value="JSON format with movie info", name = "Movie Information") @RequestBody MovieRentalJSON movieRentalJSON){
        MovieRental movieRental = movieService.rentMovie(movieRentalJSON);
        if(movieRental == null) return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(movieRental,HttpStatus.OK);
    }

    @PostMapping(value = "/return")
    @ApiOperation(value = "Return a movie to stock")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Rent found"),
            @ApiResponse(code = 304, message = "Rent not found")
    })
    public ResponseEntity<?> postReturnMovie(@ApiParam(value="JSON format with movie info", name = "Movie Information") @RequestBody MovieRentalJSON movieRentalJSON){
        MovieRental movieRental = movieService.returnMovie(movieRentalJSON);
        if(movieRental == null) return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(movieRental,HttpStatus.OK);
    }

}
