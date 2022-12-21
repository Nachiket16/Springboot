package com.annotations.spring_boot_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
@ComponentScan(basePackages = {"mypack"})
public class MyConfig {
    @Bean("Student 1")
    @Lazy
    public Student getStudent(){
        System.out.println("******** Creating first Student object using Bean *********");
        return new Student("Nachiket 1");
    }

    @Bean("Student 2")
    @Lazy
    public Student createStudent(){
        System.out.println("******** Creating Second Student object using Bean *********");
        return new Student("Nachiket 2");
    }

    @Bean
    public Date getDate(){
        System.out.println("**** Date is created ****");
        return new Date();
    }


}
