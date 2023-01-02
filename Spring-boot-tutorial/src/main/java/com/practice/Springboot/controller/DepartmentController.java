package com.practice.Springboot.controller;

import com.practice.Springboot.entitiy.Department;
import com.practice.Springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    //Logger is used for debugging the code
    //Spring boot comes with SLF4J library by default
    //For other library u have to add them into the pom.xml

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return this.departmentService.getAllDepartments();
    }

    @GetMapping("/department/{departmentId}")
    public Department fetchDepartmentById(@PathVariable Long departmentId){
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
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
