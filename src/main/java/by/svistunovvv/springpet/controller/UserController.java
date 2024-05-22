package by.svistunovvv.springpet.controller;

import by.svistunovvv.springpet.model.Account;
import by.svistunovvv.springpet.model.User;
import by.svistunovvv.springpet.service.AccountService;
import by.svistunovvv.springpet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@ResponseBody
public class UserController {
    private UserService service;
    private AccountService accountService;

    @GetMapping("")
    public List<User> index() {
        return service.findAll();
    }

    @GetMapping("/{email}")
    public User get(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @PostMapping("")
    public String save(@RequestBody User user) {
        User createdUser = service.save(user);
        Account account = Account.builder().amount((float)0).user(createdUser).primaryAccount(true).build();
        accountService.save(account);
        return "Success save";
    }

    @DeleteMapping("/{email}")
    public String delete(@PathVariable String email) {
        service.delete(email);
        return "Success delete";
    }

    @PutMapping("/{email}")
    public String update(@RequestBody User user) {
        service.update(user);
        return "Success update";
    }
}
