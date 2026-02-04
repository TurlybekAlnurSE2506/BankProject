package Entities;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    public void applyInterestToAll(List<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            if (acc instanceof InterestBearing) {
                ((InterestBearing) acc).calculateInterest();
            }
        }
    }


    public List<BankAccount> filterByBalance(List<BankAccount> accounts, double filterBalance) {
        List<BankAccount> result = new ArrayList<>();
        for (BankAccount acc : accounts) {
            if (acc.getBalance() <= filterBalance) {
                result.add(acc);
            }
        }
        return result;
    }

    public BankAccount findByUser(List<BankAccount> accounts, String username) {
        for (BankAccount acc : accounts) {
            if (acc.getUserName().equals(username)) {
                return acc;
            }
        }
        return null;
    }
}
