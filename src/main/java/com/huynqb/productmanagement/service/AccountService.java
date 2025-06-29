package com.huynqb.productmanagement.service;

import com.huynqb.productmanagement.entity.Account;
import com.huynqb.productmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Phương thức login
     * @param username tên đăng nhập
     * @param password mật khẩu
     * @return Account nếu đúng, null nếu sai
     */
    public Account login(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password)
                .orElse(null); // QUAN TRỌNG: Dùng orElse(null) không phải orElseThrow()
    }

    /**
     * Tìm tài khoản theo username
     */
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElse(null);
    }

    /**
     * Lưu tài khoản mới
     */
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}