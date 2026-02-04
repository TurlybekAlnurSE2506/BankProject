package entities;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private int bankId;

    @Column private String bankName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BankAccount> accounts;

    public Bank(int bankId, String bankName, List<Customer> customers, List<BankAccount> accounts) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.customers = customers;
        this.accounts = accounts;
    }

    public Bank() {

    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void applyInterest() {
        for (BankAccount acc : accounts) {
            acc.calculateInterest();
        }
    }

    public int customerCount() {
        return customers.size();
    }
    @Override
    public String toString(){
        return "Bank name: " + bankName +
                "\nAmount of clients: " + customerCount();
    }
    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }
}
