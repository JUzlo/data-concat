package com.example.dataconcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.dataconcat.config")
public class DataConcatApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataConcatApplication.class, args);
    }
}
