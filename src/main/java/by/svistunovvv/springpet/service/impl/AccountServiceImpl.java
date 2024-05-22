package by.svistunovvv.springpet.service.impl;

import by.svistunovvv.springpet.model.Account;
import by.svistunovvv.springpet.repository.AccountRepository;
import by.svistunovvv.springpet.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final String REGION_CODE = "BY";
    private final int COUNT_ACCOUNT_LENGTH_BY_REGION = 28;
    private AccountRepository repository;
    @Override
    public List<Account> findAccountsByUserId(Long userId) {
        return repository.findAccountsByUserId(userId);
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        return repository.findAccountByAccountNumber(accountNumber);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account save(Account account) {
        account.setAccountNumber(generateAccountNumber());
        return repository.save(account);
    }

    private String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder(REGION_CODE);
        int[] generatedAccount = IntStream.generate(
                () -> new Random().nextInt(10)
        ).limit(COUNT_ACCOUNT_LENGTH_BY_REGION).toArray();
        accountNumber.append(
                String.join(
                        "",
                        Arrays.stream(generatedAccount)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));
        return accountNumber.toString();
    }

    @Override
    public Account update(Account account) {
        return repository.save(account);
    }

    @Override
    public void delete(String accountNumber) {
        repository.deleteUserByAccountNumber(accountNumber);
    }
}
