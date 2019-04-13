package com.github.msomi22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Peter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Peter1Application.class, args);

		System.out.println("hello peter");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
