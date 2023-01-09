package com.example.listofshooping.service;

import com.example.listofshooping.model.entity.CategoryName;
import com.example.listofshooping.model.services.ProductServiceModel;
import com.example.listofshooping.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);



    BigDecimal totalSumOfProducts();


    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

    void buyById(Long id);

    void buyAll();
}
