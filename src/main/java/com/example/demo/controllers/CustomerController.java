package com.example.demo.controllers;

import com.example.demo.Service.CustomerService;
import com.example.demo.entities.BankAccount;
import com.example.demo.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/{id}/accounts")
    public Customer addAccount(@PathVariable int id, @RequestBody BankAccount account) {
        return customerService.addAccount(id, account);
    }
    @GetMapping("/{id}/total-balance")
    public Map<String, Double> getTotalBalance(@PathVariable int id) {
        double total = customerService.getTotalBalance(id);
        Map<String, Double> response = new HashMap<>();
        response.put("totalBalance", total);
        return response;
    }
}
