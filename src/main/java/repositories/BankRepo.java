package repositories;

import entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo  extends JpaRepository<Bank,Integer> {
}
