package com.videostore.movie.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Data
@Entity(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, unique = true, nullable = false, length = 36)
    @EqualsAndHashCode.Exclude
    private String id;

    @Column(name = "movie_title")
    private String movieTitle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="director_id", nullable=false)
    private Director director;

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
