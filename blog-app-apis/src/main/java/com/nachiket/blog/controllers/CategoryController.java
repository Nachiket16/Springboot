package com.nachiket.blog.controllers;

import com.nachiket.blog.payloads.CategoryDto;
import com.nachiket.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCatDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCatDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory(){
        return new ResponseEntity<>(this.categoryService.getAllCategory(), HttpStatus.OK);
    }

}
