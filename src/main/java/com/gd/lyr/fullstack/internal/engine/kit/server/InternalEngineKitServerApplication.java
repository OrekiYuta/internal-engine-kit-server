package com.gd.lyr.fullstack.internal.engine.kit.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class InternalEngineKitServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalEngineKitServerApplication.class, args);
    }

}
