package com.huynqb.productmanagement.repository;

import com.huynqb.productmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Tìm category theo tên
    Optional<Category> findByName(String name);
}