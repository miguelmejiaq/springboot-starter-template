package com.example.miguelmejiaq.labs.docker_lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile({"dev","prod"})
public class DockerLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerLabApplication.class, args);
	}

}
