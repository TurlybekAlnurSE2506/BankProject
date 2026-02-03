package com.example.demo;

import java.util.List;

public class Bank {
    private int bank_id;
    private String bank_name;
    private final List<Customer> customers;
    private List<BankAccount> accounts;
    private AccountService accountService;

    public Bank(int bank_id, String bank_name, List<Customer> customers, List<BankAccount> accounts, AccountService accountService) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.customers = customers;
        this.accounts = accounts;
        this.accountService = accountService;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    private int customerCount() {
        return customers.size();
    }
    public void applyInterest() {
        accountService.applyInterestToAll(accounts);
    }

    @Override
    public String toString(){
        return "Bank name: " + bank_name +
                "\nAmount of clients: " + customerCount();
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public int getBank_id() {
        return bank_id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}