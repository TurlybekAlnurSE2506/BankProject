package com.example.demo.entities;

import com.example.demo.Service.InterestBearing;
import com.example.demo.Service.Transferable;
import jakarta.persistence.Entity;

@Entity
public abstract class CheckingAccount extends BankAccount implements Transferable {
    private double overdraftLimit;

    public CheckingAccount(int accountId, String userName, String password, double balance, double overdraftLimit) {
        super(accountId, userName, password, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public CheckingAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public CheckingAccount() {

    }

    @Override
    public void calculateInterest(){
        System.out.println("No interest in checking account");
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
