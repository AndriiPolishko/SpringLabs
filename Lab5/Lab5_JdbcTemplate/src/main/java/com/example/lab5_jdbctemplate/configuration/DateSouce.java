package com.example.lab5_jdbctemplate.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DataSource {

    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }

}