package com.videostore.movie.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Data
public class MovieStockJSON {
    @ApiModelProperty(required = true)
    public String movieID;
    @ApiModelProperty(required = true)
    public String movieStockQtd;
}
