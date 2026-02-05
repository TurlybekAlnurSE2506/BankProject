package com.example.demo.repositories;

import com.example.demo.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo  extends JpaRepository<Bank,Integer> {
}
