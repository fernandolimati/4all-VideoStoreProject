package com.videostore.movie.service;

import com.videostore.movie.model.Movie;
import com.videostore.movie.model.MovieStock;
import com.videostore.movie.repository.MovieRespository;
import com.videostore.movie.repository.MovieStockRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieStockService {

    private final MovieStockRespository movieStockRespository;

    public Iterable<MovieStock> findAvailableMovies(){
        return movieStockRespository.findAllByMovieTotalAvailableGreaterThan(0);
    }

}
