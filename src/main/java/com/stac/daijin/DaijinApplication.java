package com.stac.daijin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@EnableJpaAuditing @EnableMongoAuditing
@SpringBootApplication
public class DaijinApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaijinApplication.class, args);
    }

}  
