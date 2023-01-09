package com.example.listofshooping.repository;

import com.example.listofshooping.model.entity.CategoryName;
import com.example.listofshooping.model.entity.Product;
import com.example.listofshooping.model.view.ProductViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<ProductViewModel> findAllByName(String name);

    @Query("select sum(p.price) from Product p")
    BigDecimal findTotalPrice();

    List<Product> findAllByCategory_Name(CategoryName category_name);
}
