package entities;
import jakarta.persistence.*;
import java.util.Objects;
@Entity
public abstract class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private int accountId;

    @Column private String userName;
    @Column private String password;
    @Column private double balance;

    public BankAccount(int accountId, String userName, String password, double balance) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
    }

    public BankAccount() {

    }

    public abstract void calculateInterest();


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
        return "Name:" + userName +
                "\nRemaining balance: " + balance;
    }

    @Override
    public String toString(){
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return accountId == that.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    public int getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
