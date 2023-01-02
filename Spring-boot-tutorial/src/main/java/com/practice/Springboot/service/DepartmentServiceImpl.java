package com.practice.Springboot.service;

import com.practice.Springboot.entitiy.Department;
import com.practice.Springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteByDepartmentId(Long id) {
        this.departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id ,Department department) {
        Department depDB = this.departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) &&       //Check for not Null
        !"".equalsIgnoreCase(department.getDepartmentName())){      //Check For Not Blank
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
        !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
        !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return this.departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
