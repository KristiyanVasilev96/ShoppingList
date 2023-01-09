package com.example.listofshooping.repository;

import com.example.listofshooping.model.entity.Category;
import com.example.listofshooping.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(CategoryName name);
}
