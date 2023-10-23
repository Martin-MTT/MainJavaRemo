package com.demo.app.main.demo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAppApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		
		return args -> {
				LOGGER.info("Looking at the beans which are provided by Spring Boot:");
				for(String beanName : ctx.getBeanDefinitionNames()) {
					LOGGER.info(beanName);
				}
		};
	}

}
