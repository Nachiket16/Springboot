package com.practice.Springboot.controller;

import com.practice.Springboot.entitiy.Department;
import com.practice.Springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
         return this.departmentService.getAllDepartments();
    }

    @GetMapping("/department/{departmentId}")
    public Department fetchDepartmentById(@PathVariable Long departmentId){
        return this.departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartmentById(@PathVariable Long id){
        this.departmentService.deleteByDepartmentId(id);
    }

    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable Long id, @RequestBody Department department){
        return this.departmentService.updateDepartmentById(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name")String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
