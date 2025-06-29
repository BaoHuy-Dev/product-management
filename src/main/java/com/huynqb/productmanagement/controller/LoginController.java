package com.huynqb.productmanagement.controller;

import com.huynqb.productmanagement.entity.Account;
import com.huynqb.productmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    /**
     * TRANG CHỦ - Redirect về trang login
     */
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    /**
     * HIỂN THỊ TRANG LOGIN
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * XỬ LÝ ĐĂNG NHẬP
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, Model model) {

        Account account = accountService.login(username, password);

        if (account != null && account.getActive()) {
            // Login thành công
            session.setAttribute("user", account);
            return "redirect:/products";
        } else {
            // Login thất bại
            if (account == null) {
                model.addAttribute("error", "❌ Tên đăng nhập hoặc mật khẩu không đúng!");
            } else {
                model.addAttribute("error", "❌ Tài khoản của bạn đã bị khóa!");
            }
            return "login";
        }
    }

    /**
     * ĐĂNG XUẤT
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}