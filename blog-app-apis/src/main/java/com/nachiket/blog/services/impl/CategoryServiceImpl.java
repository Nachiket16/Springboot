package com.nachiket.blog.services.impl;

import com.nachiket.blog.entities.Category;
import com.nachiket.blog.exception.ResourceNotFoundException;
import com.nachiket.blog.payloads.CategoryDto;
import com.nachiket.blog.repositories.CategoryRepo;
import com.nachiket.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category addedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(addedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id ", categoryId));

        this.categoryRepo.delete(cat);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id ", categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> catDto = categories.stream()
                .map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
        return catDto;
    }
}
