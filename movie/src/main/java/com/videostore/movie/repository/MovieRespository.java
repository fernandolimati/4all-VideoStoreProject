package com.videostore.movie.repository;

import com.videostore.movie.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/
public interface MovieRespository extends CrudRepository<Movie, String> {
    Movie findByMovieTitle(String movieTitle);
}
