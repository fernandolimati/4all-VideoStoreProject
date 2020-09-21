package com.videostore.user.docs;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

public class BaseSwaggerConfig {
    private final String basePackage;

    @Value("${SWAGGER_HOST:localhost}:${server.port}")
    private String swaggerHostProp;

    public BaseSwaggerConfig(String basePackage){this.basePackage = basePackage;}

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerHostProp)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("User Service")
                .description("Service responsible for managing user requests.")
                .version("1.0")
                .contact(new Contact("Fernando Lima","http://www.fernandolimati.com.br" ,"flimaeng@gmail.com"))
                .license("Private Use, belongs to Fernando Lima")
                .licenseUrl("http://www.fernandolimati.com.br")
                .build();
    }

}
