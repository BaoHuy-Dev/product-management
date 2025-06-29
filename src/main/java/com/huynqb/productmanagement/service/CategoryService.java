package com.huynqb.productmanagement.service;

import com.huynqb.productmanagement.entity.Category;
import com.huynqb.productmanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Tìm tất cả categories
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Tìm category theo ID
     */
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    /**
     * Tìm category theo tên
     */
    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    /**
     * Lưu category
     */
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}