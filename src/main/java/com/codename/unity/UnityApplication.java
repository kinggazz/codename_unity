package com.codename.unity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class UnityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnityApplication.class, args);
	}

}
