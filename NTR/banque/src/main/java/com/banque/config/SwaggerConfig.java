package com.banque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import a faire possible de springfox, dependance Maven ?

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.uphf.bugtrackingweb.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bug API")
                .description("API for bugtracking")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}