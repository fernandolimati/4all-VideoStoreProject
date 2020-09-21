package com.videostore.movie.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Data
public class MovieJSON {
    @ApiModelProperty(required = true)
    public String movieTitle;
    @ApiModelProperty(required = true)
    public String movieDirector;
}
