package com.example.demo.Service;

import com.example.demo.entities.BankAccount;
import com.example.demo.entities.Customer;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.CustomerRepo;

import java.util.List;
@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    public double getTotalBalance(int CustomerId) {
        Customer customer = customerRepo.findById(CustomerId).orElseThrow(()
                -> new RuntimeException("Customer not found"));
        return customer.getBankAccounts()
                .stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }
    public Customer addAccount(int CustomerId, BankAccount bankAccount) {
        Customer customer = customerRepo.findById(CustomerId).orElseThrow(()
                -> new RuntimeException("Customer not found"));
        customer.getBankAccounts().add(bankAccount);
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
