package com.practice.Springboot.service;

import com.practice.Springboot.entitiy.Department;
import com.practice.Springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {

        Department savedDepartment = this.departmentRepository.save(department);
        return savedDepartment;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = this.departmentRepository.findAll();
        return list;
    }
}
