package com.annotations.spring_boot_annotation;

import mypack.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootAnnotationApplication implements CommandLineRunner {

	@Autowired
	@Qualifier(("Student 2"))
	private Student student;

	@Autowired
	private Date date;

	@Autowired
	private Emp emp;

	@Autowired
	private Dog dog;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.student.studying();

		this.date.getTime();

		this.emp.whatsYourName();

		this.dog.eating();
	}
}
