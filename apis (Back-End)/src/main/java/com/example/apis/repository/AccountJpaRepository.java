package com.example.apis.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apis.model.Account;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Integer> {
      Optional<Account> findByMailId(String email);


}
