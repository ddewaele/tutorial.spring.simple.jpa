package com.ecs.tutorial.jpa;

import com.ecs.tutorial.jpa.repository.PromotionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class SimpleJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimpleJpaApplication.class, args);
    }

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Found {} promotions",promotionRepository.findAll().size());
    }
}
