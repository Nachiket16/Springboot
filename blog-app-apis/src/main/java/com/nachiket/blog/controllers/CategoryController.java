package com.nachiket.blog.controllers;

import com.nachiket.blog.payloads.ApiResponse;
import com.nachiket.blog.payloads.CategoryDto;
import com.nachiket.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
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

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@Valid @PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.ok(this.categoryService.getCategory(categoryId));
    }


    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
                                                      @PathVariable("categoryId") Integer categoryId) {
        CategoryDto catDto = this.categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(catDto);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@Valid @PathVariable("categoryId") Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category Has Been Deleted Successfully", true), HttpStatus.OK);
    }



}
