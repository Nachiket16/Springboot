package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Course;
import com.nachiketjpa.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    void printCourse(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void  saveCourseWithTeacher(){
        Teacher teacher =
                Teacher
                        .builder()
                        .firstName("Aditya")
                        .lastName("Singh")
                        .build();
        Course course =
                Course
                        .builder()
                        .title("Python")
                        .credit(10)
                        .title("Python in depth")
                        .teacher(teacher)
                        .build();


        courseRepository.save(course);
        System.out.println("course = " + course);
    }

}