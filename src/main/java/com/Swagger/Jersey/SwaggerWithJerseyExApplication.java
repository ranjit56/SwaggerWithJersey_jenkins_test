package com.Swagger.Jersey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerWithJerseyExApplication implements CommandLineRunner {

	public final static Logger logger = LoggerFactory.getLogger(SwaggerWithJerseyExApplication.class);

	public static void main(String[] args) {
		logger.info("continuous integration");
		SpringApplication.run(SwaggerWithJerseyExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("its second logger");
	}

}