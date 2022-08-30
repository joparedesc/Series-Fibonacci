package com.series.fibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * FibonacciApplication class.
 * @author jesu_
 */
@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class FibonacciApplication {

	/**
	 * Main method.
	 * Method to execute application.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FibonacciApplication.class, args);
	}

}
