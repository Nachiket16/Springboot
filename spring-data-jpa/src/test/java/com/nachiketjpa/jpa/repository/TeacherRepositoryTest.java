package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Course;
import com.nachiketjpa.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseSpring =
                Course
                        .builder()
                        .title("Spring Boot")
                        .credit(10)
                        .title("Spring 3.0.1")
                        .build();

        Course courseDsa =
                Course
                        .builder()
                        .title("DSA")
                        .credit(10)
                        .title("Data Structure in depth")
                        .build();

        Teacher teacher =
                Teacher
                        .builder()
                        .firstName("Durgesh")
                        .lastName("Gupta")
                        .courses(List.of(courseSpring,courseDsa))
                        .build();

        teacherRepository.save(teacher);
    }

}