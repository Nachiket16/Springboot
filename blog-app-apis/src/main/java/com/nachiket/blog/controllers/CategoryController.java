package com.nachiket.blog.controllers;

import com.nachiket.blog.payloads.ApiResponse;
import com.nachiket.blog.payloads.CategoryDto;
import com.nachiket.blog.payloads.UserDto;
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
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCatDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCatDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return new ResponseEntity<>(this.categoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CategoryDto> getCategory(@Valid @PathVariable("courseId") Integer courseId) {
        return ResponseEntity.ok(this.categoryService.getCategory(courseId));
    }


    @PutMapping("/{courseID}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
                                                      @PathVariable("courseID") Integer courseID) {
        CategoryDto catDto = this.categoryService.updateCategory(categoryDto, courseID);
        return ResponseEntity.ok(catDto);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<ApiResponse> deleteCategory(@Valid @PathVariable("courseId") Integer courseID) {
        this.categoryService.deleteCategory(courseID);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category Has Been Deleted Successfully", true), HttpStatus.OK);
    }



}
