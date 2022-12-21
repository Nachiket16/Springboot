package com.annotations.spring_boot_annotation;

public class Student {
    String name;

     public Student(String name){
         this.name = name;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void studying(){
        System.out.println("******** I am "+ name +" studying the annotation *********");
    }

}
