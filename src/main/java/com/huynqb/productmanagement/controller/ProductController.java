package com.huynqb.productmanagement.controller;

import com.huynqb.productmanagement.entity.Account;
import com.huynqb.productmanagement.entity.Product;
import com.huynqb.productmanagement.entity.Category;
import com.huynqb.productmanagement.service.ProductService;
import com.huynqb.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    private Account getCurrentUser(HttpSession session) {
        return (Account) session.getAttribute("user");
    }

    /**
     * HIỂN THỊ DANH SÁCH SẢN PHẨM + TÌM KIẾM
     */
    @GetMapping
    public String listProducts(@RequestParam(required = false) String search,
                               HttpSession session, Model model) {

        Account user = getCurrentUser(session);
        if (user == null) {
            return "redirect:/login";
        }

        List<Product> products = productService.search(search);

        model.addAttribute("products", products);
        model.addAttribute("user", user);
        model.addAttribute("search", search);

        return "product-list";
    }

    /**
     * HIỂN THỊ FORM TẠO SẢN PHẨM MỚI
     */
    @GetMapping("/create")
    public String createForm(HttpSession session, Model model) {
        Account user = getCurrentUser(session);
        if (user == null || !user.isAdmin()) {
            return "redirect:/products";
        }

        List<Category> categories = categoryService.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categories);
        model.addAttribute("user", user);

        return "product-form";
    }

    /**
     * HIỂN THỊ FORM SỬA SẢN PHẨM
     */
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, HttpSession session, Model model) {
        Account user = getCurrentUser(session);
        if (user == null || !user.isAdmin()) {
            return "redirect:/products";
        }

        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }

        List<Category> categories = categoryService.findAll();

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("user", user);

        return "product-form";
    }

    /**
     * LƯU SẢN PHẨM
     */
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, HttpSession session) {
        Account user = getCurrentUser(session);
        if (user == null || !user.isAdmin()) {
            return "redirect:/products";
        }

        productService.save(product);
        return "redirect:/products";
    }

    /**
     * XÓA SẢN PHẨM
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, HttpSession session) {
        Account user = getCurrentUser(session);
        if (user == null || !user.isAdmin()) {
            return "redirect:/products";
        }

        productService.deleteById(id);
        return "redirect:/products";
    }
}