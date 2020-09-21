package com.videostore.movie.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/
@Data
public class MovieRentalJSON {
    @ApiModelProperty(required = true)
    public String userEmail;
    @ApiModelProperty(required = true)
    public String movieID;
}
