package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Course;
import com.nachiketjpa.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;
    @Autowired
    private CourseRepository courseRepository;

//    @BeforeEach
//    void setUp() {
//    }

    @Test
    public void SaveCourseMaterial(){
        Course course = 
                Course.builder()
                        .title("DSA")
                        .credit(6)
                        .build();
                
        CourseMaterial courseMaterial =
                CourseMaterial
                        .builder()
                        .url("www.google.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("all = " + courseMaterials);
    }   

}