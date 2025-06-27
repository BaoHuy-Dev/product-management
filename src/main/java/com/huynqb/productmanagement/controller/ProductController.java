package com.huynqb.productmanagement.controller;

import com.huynqb.productmanagement.entity.Account;
import com.huynqb.productmanagement.entity.Category;
import com.huynqb.productmanagement.entity.Product;
import com.huynqb.productmanagement.service.CategoryService;
import com.huynqb.productmanagement.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    public String listProducts(@RequestParam(required = false) String search, HttpSession session, Model model) {
        Account user = getCurrentUser(session);
        if (user == null) {
            return "redirect:/login";
        }

        List<Product> products = productService.searchByName(search);

        model.addAttribute("products", products);
        model.addAttribute("user", user);
        model.addAttribute("search", search);

        return "products-list";
    }

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
}
