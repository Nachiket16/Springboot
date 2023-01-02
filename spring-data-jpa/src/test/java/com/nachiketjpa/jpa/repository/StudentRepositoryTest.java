package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Guardian;
import com.nachiketjpa.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest         //This will impact the DB
//@DataJpaTest          //This will not impact the DB
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("nachiket@gmail.com")
                .firstName("Nachiket")
                .lastName("Khule")
//                .guardianName("Madhusudan")
//                .guardianEmail("madhu@yahoo.in")
//                .guardianMobile("12312312312")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian
                .builder()
                .name("Madhusudan")
                .email("madhu@yahoo.in")
                .mobile("12312312312")
                .build();

        Student student = Student.builder()
                .firstName("Shiva")
                .emailId("shiva@kailash.com")
                .lastName("lord")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList = " + studentList);
    }
    
    @Test
    public void printStudentByFirstName(){
        List<Student> students = 
                studentRepository.findByFirstName("shiva");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("a");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Madhusudan");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        Student students =
                studentRepository.findByFirstNameAndLastName("Shiva","lord");
        System.out.println("students = " + students);
    }


}