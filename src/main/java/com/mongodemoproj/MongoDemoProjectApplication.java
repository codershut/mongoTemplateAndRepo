package com.mongodemoproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class MongoDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoProjectApplication.class, args);
	}

}
