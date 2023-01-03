package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Course;
import com.nachiketjpa.jpa.entity.Guardian;
import com.nachiketjpa.jpa.entity.Student;
import com.nachiketjpa.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("courses = " + courses);

        Long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalElements();

        Long totalpages =
                (long) courseRepository.findAll(firstPageWithThreeRecords)
                                .getTotalPages();

        System.out.println("totalpages = " + totalpages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);

    }
    
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = 
                PageRequest.of(0,2, Sort.by("title"));
        
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        
        List<Course> courses = 
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByContaining(){
        Pageable firstPageTenRecord =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining("z", firstPageTenRecord ).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher =
                Teacher.builder()
                        .firstName("Elon")
                        .lastName("Musk")
                        .build();

        Guardian guardian =
                Guardian.builder()
                        .name("SharmaJi")
                        .email("sharmajika@ladka.com")
                        .mobile("9999999999")
                        .build();

        Student student =
                Student.builder()
                        .firstName("Parag")
                        .lastName("Patole")
                        .emailId("parag@tesla.com")
                        .guardian(guardian)
                        .build();

        Course course =
                Course.builder()
                        .title("AI")
                        .credit(10)
                        .teacher(teacher)
                        .build();

        course.addStudents(student);

        courseRepository.save(course);

    }

}