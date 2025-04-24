package com.udacity.vehicles.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi carApi() {
        return GroupedOpenApi.builder()
                .group("cars")
                .pathsToMatch("/cars/**")
                .build();
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info().title("Vehicle API")
                        .description("API for CRUD operation of vehicle info."));
    }
}
