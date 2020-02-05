package com.greenfox.error;

import com.greenfox.error.model.User;
import com.greenfox.error.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinderApplication implements CommandLineRunner {

	UserService service;

	@Autowired
	public FinderApplication(UserService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.save(new User("Attila", "Yolo"));
		service.save(new User("Sanya", "Csanya"));
		service.save(new User("Balazs", "Bela"));
		service.save(new User("At", "Yo"));
	}
}
