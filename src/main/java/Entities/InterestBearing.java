package Entities;

public interface InterestBearing {
    void calculateInterest();

    interface Transferable {
        void transfer(int amount, BankAccount target);
    }
}
