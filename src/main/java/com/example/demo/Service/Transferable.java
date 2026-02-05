package com.example.demo.Service;

import com.example.demo.entities.BankAccount;

public interface Transferable {
        void transfer(int amount, BankAccount target);

}
