package com.videostore.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Data
@Entity(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @Id
    @Email
    @Column(name = "user_email")
    @ApiModelProperty(notes = "User email",example = "me@gmail.com",position = 0 ,required = true)
    private String userEmail;

    @Column(name = "user_name")
    @ApiModelProperty(notes = "Name of user",example = "Jose da Silva",position = 1)
    private String userName;

    @JsonIgnore
    @ToString.Exclude
    @ApiModelProperty(notes = "User password",position = 2, required = true)
    @Column(name = "user_password")
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date",updatable = false)
    @ApiModelProperty(hidden=true)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    @ApiModelProperty(hidden=true)
    @JsonInclude(content = JsonInclude.Include.NON_EMPTY, value = JsonInclude.Include.NON_NULL)
    private Date updatedDate;

}
