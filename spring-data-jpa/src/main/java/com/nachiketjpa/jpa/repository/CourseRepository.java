package com.nachiketjpa.jpa.repository;

import com.nachiketjpa.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}