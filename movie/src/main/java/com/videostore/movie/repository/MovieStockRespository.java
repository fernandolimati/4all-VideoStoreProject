package com.videostore.movie.repository;

import com.videostore.movie.model.Director;
import com.videostore.movie.model.Movie;
import com.videostore.movie.model.MovieStock;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/
public interface MovieStockRespository extends CrudRepository<MovieStock, String> {
    Iterable<MovieStock> findAllByMovieTotalAvailableGreaterThan(long qtd);
    MovieStock findByMovie_IdAndAndMovieTotalAvailableGreaterThan(String movieID,long qtd);
}
