package com.annotations.spring_boot_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MyConfig {
    @Bean
    public Student getStudent(){
        System.out.println("******** Inside the MyConfig Bean *********");
        return new Student();
    }

    @Bean
    public Date getDate(){
        System.out.println("**** Date is created ****");
        return new Date();
    }


}
