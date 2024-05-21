package by.svistunovvv.springpet.service;

import by.svistunovvv.springpet.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByEmail(String email);
    User save(User user);
    User update(User user);
    void delete(String email);
}


