package repositories;

import entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo  extends JpaRepository<BankAccount,Integer> {
}
