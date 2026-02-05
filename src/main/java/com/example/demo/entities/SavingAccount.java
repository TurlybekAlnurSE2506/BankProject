package com.example.demo.entities;

import com.example.demo.Service.InterestBearing;
import jakarta.persistence.Entity;

@Entity
public class SavingAccount extends BankAccount implements InterestBearing {
    private double interestRate;

    public SavingAccount(int account_id, String user_name, String password, double balance, double interestRate) {
        super(account_id, user_name, password, balance);
        this.interestRate = interestRate;
    };

    public SavingAccount() {

    }

    @Override
    public void calculateInterest() {
        setBalance((int) (getBalance() * interestRate));
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
