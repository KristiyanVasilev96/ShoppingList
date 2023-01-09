package com.example.listofshooping.service;

import com.example.listofshooping.model.entity.Category;
import com.example.listofshooping.model.entity.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByCategoryName(CategoryName category);
}
