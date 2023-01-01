package com.practice.Springboot.service;

import com.practice.Springboot.entitiy.Department;
import com.practice.Springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> getAllDepartments();
}
