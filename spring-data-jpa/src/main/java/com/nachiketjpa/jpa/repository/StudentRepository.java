package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String LastName);

    //JPQL Query based
    // Use ? for the JPQL if you are taking input from the user side
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String EmailId);
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String EmailId);

}
