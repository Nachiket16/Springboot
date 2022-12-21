package com.annotations.spring_boot_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootAnnotationApplication implements CommandLineRunner {

	@Autowired
	private Student student;

	@Autowired
	private Date date;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAnnotationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.student.studying();

		this.date.getTime();
	}
}
