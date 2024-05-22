package by.svistunovvv.springpet.service;

import by.svistunovvv.springpet.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAccountsByUserId(Long userId);
    Account findAccountByAccountNumber(String accountNumber);
    List<Account> findAll();
    Account save(Account account);
    Account update(Account account);
    void delete(String accountNumber);
}
