package com.swheroes.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controller.SwheroController;
import repository.SwheroRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackageClasses = SwheroController.class)
@EnableJpaRepositories(basePackageClasses = {SwheroRepository.class})
@EntityScan
@EnableSwagger2
public class SwHeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwHeroesApplication.class, args);
	}
}
