package com.example.listofshooping.service.impl;

import com.example.listofshooping.model.entity.Category;
import com.example.listofshooping.model.entity.CategoryName;
import com.example.listofshooping.repository.CategoryRepository;
import com.example.listofshooping.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count()==0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category=new Category();
                        category.setName(categoryName);
                        category.setDescription("Description of "+categoryName);

                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryName(CategoryName category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
