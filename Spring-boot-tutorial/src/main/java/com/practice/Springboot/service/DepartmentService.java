package com.practice.Springboot.service;

import com.practice.Springboot.entitiy.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void deleteByDepartmentId(Long id);

    Department updateDepartmentById(Long id ,Department department);

    Department fetchDepartmentByName(String departmentName);
}
