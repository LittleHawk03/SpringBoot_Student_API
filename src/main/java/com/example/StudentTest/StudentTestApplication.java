package com.example.StudentTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class StudentTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentTestApplication.class, args);
	}

}
