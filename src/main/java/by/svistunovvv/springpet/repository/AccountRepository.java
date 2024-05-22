package by.svistunovvv.springpet.repository;

import by.svistunovvv.springpet.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAccountsByUserId(Long userId);
    Account findAccountByAccountNumber(String accountNumber);

    void deleteUserByAccountNumber(String accountNumber);
}
