package com.huynqb.productmanagement.service;

import com.huynqb.productmanagement.entity.Product;
import com.huynqb.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Tìm tất cả sản phẩm
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Tìm sản phẩm theo ID
     */
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Lưu sản phẩm (tạo mới hoặc cập nhật)
     */
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /**
     * Xóa sản phẩm theo ID
     */
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Tìm kiếm sản phẩm (có thể null hoặc empty)
     */
    public List<Product> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return findAll(); // Trả về tất cả nếu không có keyword
        }
        return productRepository.findByNameContainingIgnoreCase(keyword.trim());
    }
}