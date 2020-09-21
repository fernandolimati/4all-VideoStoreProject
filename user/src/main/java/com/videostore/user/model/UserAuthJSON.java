package com.videostore.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Data
public class UserAuthJSON {
    @ApiModelProperty(example = "me@gmail.com", required = true)
    private String userEmail;
    @ApiModelProperty(required = true)
    private String userPassword;
}
