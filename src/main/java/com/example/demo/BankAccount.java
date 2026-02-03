package com.example.demo;

import java.util.Objects;
import java.util.Scanner;

public abstract class BankAccount {
    protected int account_id;
    protected String user_name;
    protected String password;
    protected double balance;

    public BankAccount(int account_id, String user_name, String password, double balance) {
        this.account_id = account_id;
        this.user_name = user_name;
        this.password = password;
        this.balance = balance;
    }
    public double deposit(int amount){
        balance = balance + amount;
        return balance;
    }
    public double withdraw(int amount){
        if(balance >= amount && amount >= 0){
            balance = balance - amount;
        } else {
            System.out.println("Not enough balance");
        }
        return balance;
    }
    public abstract void calculateInterest();

    public void transfer(int amount, BankAccount targetAccount) {
        if (this.balance >= amount && amount > 0) {
            this.balance -= amount;
            targetAccount.balance += amount;
            System.out.println("Transfer successful");
        } else {
            System.out.println("Transfer failed: insufficient funds");
        }
    }
    public String displayInfo(){
        return "Name:" + user_name +
                "\nRemaining balance: " + balance;
    }

    @Override
    public String toString(){
        return user_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return account_id == that.account_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id);
    }
    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
