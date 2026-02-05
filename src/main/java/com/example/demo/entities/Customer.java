package com.example.demo.entities;
import jakarta.persistence.*;
import java.util.List;
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private int customerId;

    @Column private String name;
    @Column private String surname;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BankAccount> bankAccounts;

    public Customer(int customerId, String name, String surname,  List<BankAccount> bankAccounts) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.bankAccounts = bankAccounts;
    }

    public Customer() {

    }
    @Override
    public String toString() {
        return "Name: " + name + " " + surname +
                "\nAccounts: " + bankAccounts;
    };

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
