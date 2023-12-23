package org.technicaltest.starwars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.technicaltest.starwars.errors.ErrorAPI;
import org.technicaltest.starwars.utils.Mapper;

import static org.technicaltest.starwars.utils.SystemConstants.ERROR;

@Configuration
public class StartWarsConfiguration {

    @Bean
    public ErrorAPI error() {
        return new ErrorAPI(ERROR);
    }

    @Bean
    public Mapper filmMapper() {
        return new Mapper();
    }

}