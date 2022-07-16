package edu.ifma.keeper.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração responsável por 
 * tornar a Classe ModelMappper um Bean
 * gerenciado pelo Spring Boot.
 */
@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modalMapper() {
        return new ModelMapper();
    }
}
