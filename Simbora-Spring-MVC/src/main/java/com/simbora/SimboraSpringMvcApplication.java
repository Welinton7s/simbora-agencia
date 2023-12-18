package com.simbora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"curso*"})
public class SimboraSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimboraSpringMvcApplication.class, args);
	}

}
