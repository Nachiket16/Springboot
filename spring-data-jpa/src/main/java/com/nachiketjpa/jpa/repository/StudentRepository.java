package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
}
