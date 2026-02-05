package com.example.demo.Service;

import com.example.demo.entities.Bank;
import com.example.demo.entities.BankAccount;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.BankRepo;
import com.example.demo.repositories.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class BankService{
    private final BankRepo  bankRepo;
    private final CustomerRepo customerRepo;

    public BankService(BankRepo bankRepo,  CustomerRepo customerRepo) {
        this.bankRepo = bankRepo;
        this.customerRepo = customerRepo;
    }

    public Bank addCustomer(int bankId, int  customerId) {
           Bank bank = bankRepo.findById(bankId).orElseThrow(()
                -> new RuntimeException("Bank not found"));
           Customer customer = customerRepo.findById(customerId).orElseThrow(()
                -> new RuntimeException("Customer not found"));
            bank.getCustomers().add(customer);
            return bankRepo.save(bank);
    }
    public Bank removeCustomer(int bankId, int  customerId) {
        Bank bank = bankRepo.findById(bankId).orElseThrow(()
                -> new RuntimeException("Bank not found"));
        Customer customer = customerRepo.findById(customerId).orElseThrow(()
                -> new RuntimeException("Customer not found"));
        bank.getCustomers().remove(customer);
        return bankRepo.save(bank);
    }

    public void applyInterest(int bankId) {
        Bank bank = bankRepo.findById(bankId).orElseThrow(()
                -> new RuntimeException("Bank not found"));
        bank.getAccounts().forEach(BankAccount::calculateInterest);
        bankRepo.save(bank);
    }


}
