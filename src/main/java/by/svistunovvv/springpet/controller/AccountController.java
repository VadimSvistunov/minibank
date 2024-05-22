package by.svistunovvv.springpet.controller;

import by.svistunovvv.springpet.model.Account;
import by.svistunovvv.springpet.model.User;
import by.svistunovvv.springpet.service.AccountService;
import by.svistunovvv.springpet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
@ResponseBody
public class AccountController {
    private final AccountService service;
    private final UserService userService;
    @GetMapping("")
    public List<Account> index() {
        return service.findAll();
    }

    @GetMapping("/{email}")
    public List<Account> getAllAccountsByUser(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return service.findAccountsByUserId(user.getId());
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable String accountNumber) {
        return service.findAccountByAccountNumber(accountNumber);
    }

    @PostMapping("")
    public String save(@RequestBody Account account) {
        service.save(account);
        return "Success save";
    }

    @PutMapping("")
    public String update(@RequestBody Account account) {
        service.update(account);
        return "Success update";
    }

    @DeleteMapping("/{accountNumber}")
    public String delete(@PathVariable String accountNumber) {
        service.delete(accountNumber);
        return "Success delete";
    }
}
