package com.example.listofshooping.service.impl;

import com.example.listofshooping.model.entity.CategoryName;
import com.example.listofshooping.model.entity.Product;
import com.example.listofshooping.model.services.ProductServiceModel;
import com.example.listofshooping.model.view.ProductViewModel;
import com.example.listofshooping.repository.ProductRepository;
import com.example.listofshooping.service.CategoryService;
import com.example.listofshooping.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product=modelMapper.map(productServiceModel,Product.class);
        product.setCategory(categoryService.findByCategoryName(productServiceModel.getCategory()));

        productRepository.save(product);
    }



    @Override
    public BigDecimal totalSumOfProducts() {
        return productRepository.findTotalPrice();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName) {
       return productRepository.findAllByCategory_Name(categoryName)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
