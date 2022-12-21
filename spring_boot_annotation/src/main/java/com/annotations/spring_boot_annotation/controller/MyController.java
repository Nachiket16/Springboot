package com.annotations.spring_boot_annotation.controller;

import com.annotations.spring_boot_annotation.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    @Qualifier("Student 1")
    private Student student;
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public Student home(){
        System.out.println("this is home method");
        this.student.setName("Nachiket Madhusuda Khule");
        return this.student;
    }
}
