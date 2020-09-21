package com.videostore.movie.repository;

import com.videostore.movie.model.MovieRental;
import com.videostore.movie.model.MovieRentalStatusEnum;
import com.videostore.movie.model.MovieStock;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

public interface MovieRentalRespository extends CrudRepository<MovieRental, UUID> {
    Iterable<MovieRental> findByUserEmailAndAndMovieRentalStatusEnumEquals(String userEmail, MovieRentalStatusEnum movieRentalStatus);
}
