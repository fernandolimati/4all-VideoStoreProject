package com.videostore.movie.repository;

import com.videostore.movie.model.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

public interface DirectorRespository extends CrudRepository<Director, String> {
    Director findByDirectorName(String directorName);
}
