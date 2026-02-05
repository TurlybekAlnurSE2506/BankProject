package com.example.demo.Service;

import com.example.demo.entities.Bank;
import com.example.demo.entities.BankAccount;
import com.example.demo.repositories.BankAccountRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BankAccountService {
    private final BankAccountRepo bankAccountRepo;

    public BankAccountService(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }

    public BankAccount deposit(int accountId ,double amount){
        BankAccount bankAccount = bankAccountRepo.findById(accountId).orElseThrow(()
                -> new RuntimeException("Account not found"));
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        return bankAccountRepo.save(bankAccount);
    }

    public BankAccount withdraw(int accountId,double amount){
        BankAccount bankAccount = bankAccountRepo.findById(accountId).orElseThrow(()
                -> new RuntimeException("Account not found"));
        if(amount <= 0){
            throw new  RuntimeException("Amount must be greater than zero");
        } else if (bankAccount.getBalance() >= amount){
            throw new  RuntimeException("Insufficient balance");
        } else{
            bankAccount.setBalance(bankAccount.getBalance()-amount);
        }
        return  bankAccountRepo.save(bankAccount);
    }

    public void transfer(int fromId, int toId, double amount) {
        BankAccount fromAcc = bankAccountRepo.findById(fromId).orElseThrow(()
                -> new RuntimeException("Account not found"));
        BankAccount toAcc = bankAccountRepo.findById(toId).orElseThrow(()
                -> new RuntimeException("Account not found"));
        if(amount <= 0){
            throw new  RuntimeException("Amount must be greater than zero");
        }
        fromAcc.setBalance(fromAcc.getBalance()-amount);
        toAcc.setBalance(toAcc.getBalance()+amount);

        bankAccountRepo.save(fromAcc);
        bankAccountRepo.save(toAcc);

    }

//    public List<BankAccount> filterByBalance(List<BankAccount> accounts, double filterBalance) {
//        List<BankAccount> result = new ArrayList<>();
//        for (BankAccount acc : accounts) {
//            if (acc.getBalance() <= filterBalance) {
//                result.add(acc);
//            }
//        }
//        return result;
//    }
//
//    public BankAccount findByUser(List<BankAccount> accounts, String username) {
//        for (BankAccount acc : accounts) {
//            if (acc.getUserName().equals(username)) {
//                return acc;
//            }
//        }
//        return null;
//    }
}
