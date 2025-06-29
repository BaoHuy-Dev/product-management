package com.huynqb.productmanagement.repository;

import com.huynqb.productmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Tìm account theo username và password (cho login)
    Optional<Account> findByUsernameAndPassword(String username, String password);

    // Tìm account theo username (để kiểm tra trùng lặp)
    Optional<Account> findByUsername(String username);
}