package br.com.anderson.rhsolutionAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class RhsolutionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhsolutionApiApplication.class, args);
	}

}
