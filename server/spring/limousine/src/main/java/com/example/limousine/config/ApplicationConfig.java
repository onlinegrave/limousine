package com.example.limousine.config;

import com.google.gson.Gson;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

// @EnableJdbcHttpSession
@Configuration
public class ApplicationConfig {

  @Bean
  public ModelMapper getModelMapper() {
    final ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    return mapper;
  }

  @Bean
  public Gson getGson() {
    return new Gson();
  }

}
