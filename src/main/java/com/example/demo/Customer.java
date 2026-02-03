package com.example.demo;

import java.util.List;

public class Customer {
    private int customer_id;
    private String name;
    private String surname;
    private List<BankAccount> bankAccounts;

    public Customer(int customer_id, String name, String surname,  List<BankAccount> bankAccounts) {
        this.customer_id = customer_id;
        this.name = name;
        this.surname = surname;
        this.bankAccounts = bankAccounts;
    }
    public void addAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }
    public String getTotalBalance() {
        double total = bankAccounts.stream().mapToDouble(bankAccounts -> bankAccounts.getBalance()).sum();
        return "Total balance: " + total;
    }
    @Override
    public String toString() {
        return "Name: " + name + " " + surname +
                "\nAccounts: " + bankAccounts +
                "\n" + getTotalBalance();
    };

    public int getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
