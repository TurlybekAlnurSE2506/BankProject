package Service;

import entities.BankAccount;

public interface InterestBearing {
    void calculateInterest();

    interface Transferable {
        void transfer(int amount, BankAccount target);
    }
}
