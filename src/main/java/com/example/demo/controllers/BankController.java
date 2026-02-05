package com.example.demo.controllers;

import com.example.demo.Service.BankService;
import com.example.demo.entities.Bank;
import com.example.demo.entities.BankAccount;
import com.example.demo.repositories.BankRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/{bankId}/customers/{customerId}")
    public Bank addCustomer(
            @PathVariable int bankId,
            @PathVariable int customerId
    ){
         return bankService.addCustomer(bankId, customerId);
    }
    @PostMapping("/{bankId}/customers/{customerId}")
    public Bank removeCustomer(
            @PathVariable int bankId,
            @PathVariable int customerId
    ){
        return bankService.removeCustomer(bankId, customerId);
    }
    @PostMapping("/{bankId}/apply-interest")
    public void applyInterest(@PathVariable int bankId){
        bankService.applyInterest(bankId);
    }
}
