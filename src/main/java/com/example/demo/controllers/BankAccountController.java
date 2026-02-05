package com.example.demo.controllers;

import com.example.demo.Service.BankAccountService;
import com.example.demo.entities.BankAccount;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/{id}/deposit")
    public BankAccount deposit(@PathVariable int id,@RequestParam double amount) {
        return bankAccountService.deposit(id, amount);
    }
    @PostMapping("/{id}/withdraw")
    public BankAccount withdraw(@PathVariable int id,@RequestParam double amount) {
        return bankAccountService.withdraw(id, amount);
    }
    @PostMapping("/transfer")
    public void transfer(
            @RequestParam int from, @RequestParam int to, @RequestParam double amount) {
        bankAccountService.transfer(from, to, amount);
    }
}
