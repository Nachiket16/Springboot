package com.example.springbootproject;

import com.example.springbootproject.dao.UserRepository;
import com.example.springbootproject.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringbootprojectApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);
		User user = new User();
		user.setName("Nachikt");
		user.setCity("Nashik");
		user.setStatus("I am Java Programmer");
		User user1 = userRepository.save(user);

		System.out.println(user1);
	}


}
