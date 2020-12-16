package com.exampedia.exampedia_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ExampediaApiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ExampediaApiApplication.class, args);
		//repository.save(new User(1,"ramu","ramu","USER",true));
	}

}
