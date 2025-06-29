package com.huynqb.productmanagement.config;


import com.huynqb.productmanagement.entity.Account;
import com.huynqb.productmanagement.entity.Category;
import com.huynqb.productmanagement.entity.Product;
import com.huynqb.productmanagement.repository.AccountRepository;
import com.huynqb.productmanagement.repository.CategoryRepository;
import com.huynqb.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        // TẠO TÀI KHOẢN MẪU
        if (accountRepository.count() == 0) {  // Nếu chưa có tài khoản nào
            System.out.println("Đang tạo tài khoản mẫu...");

            // Tạo tài khoản admin
            Account admin = new Account("admin", "Quản trị viên", "admin123", 1, true);
            accountRepository.save(admin);

            // Tạo tài khoản staff
            Account staff = new Account("staff", "Nhân viên", "staff123", 2, true);
            accountRepository.save(staff);

            // Tạo tài khoản member
            Account member = new Account("member", "Thành viên", "member123", 3, true);
            accountRepository.save(member);

            System.out.println("✅ Đã tạo 3 tài khoản mẫu!");
        }

        // TẠO DANH MỤC VÀ SẢN PHẨM MẪU
        if (categoryRepository.count() == 0) {  // Nếu chưa có danh mục nào
            System.out.println("Đang tạo danh mục và sản phẩm mẫu...");

            // Tạo các danh mục
            Category beer = categoryRepository.save(new Category("Bia/rượu"));
            Category frozen = categoryRepository.save(new Category("Thực phẩm đông lạnh"));
            Category candy = categoryRepository.save(new Category("Bánh kẹo"));
            Category office = categoryRepository.save(new Category("Văn phòng phẩm"));

            // Tạo sản phẩm thuộc danh mục "Bia/rượu"
            productRepository.save(new Product(
                    "Bia Tiger",
                    new BigDecimal("25000"),
                    100,
                    LocalDate.now(),
                    beer
            ));

            productRepository.save(new Product(
                    "Rượu Vodka",
                    new BigDecimal("350000"),
                    50,
                    LocalDate.now(),
                    beer
            ));

            // Tạo sản phẩm thuộc danh mục "Thực phẩm đông lạnh"
            productRepository.save(new Product(
                    "Tôm đông lạnh",
                    new BigDecimal("180000"),
                    30,
                    LocalDate.now(),
                    frozen
            ));

            productRepository.save(new Product(
                    "Cá hồi",
                    new BigDecimal("450000"),
                    20,
                    LocalDate.now(),
                    frozen
            ));

            // Tạo sản phẩm thuộc danh mục "Bánh kẹo"
            productRepository.save(new Product(
                    "Bánh quy Oreo",
                    new BigDecimal("45000"),
                    80,
                    LocalDate.now(),
                    candy
            ));

            productRepository.save(new Product(
                    "Kẹo dẻo",
                    new BigDecimal("25000"),
                    60,
                    LocalDate.now(),
                    candy
            ));

            // Tạo sản phẩm thuộc danh mục "Văn phòng phẩm"
            productRepository.save(new Product(
                    "Bút bi",
                    new BigDecimal("5000"),
                    200,
                    LocalDate.now(),
                    office
            ));

            productRepository.save(new Product(
                    "Giấy A4",
                    new BigDecimal("85000"),
                    40,
                    LocalDate.now(),
                    office
            ));

            System.out.println("✅ Đã tạo 4 danh mục và 8 sản phẩm mẫu!");
        }

        System.out.println("🎉 Khởi tạo dữ liệu hoàn tất!");
    }
}