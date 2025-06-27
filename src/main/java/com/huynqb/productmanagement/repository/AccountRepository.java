package com.huynqb.productmanagement.repository;

import com.huynqb.productmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {


    Optional<Account> findByUsernameAndPassword(String username, String password);


    Optional<Account> findByUsername(String username);


}
