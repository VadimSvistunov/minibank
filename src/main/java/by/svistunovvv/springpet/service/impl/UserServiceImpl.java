package by.svistunovvv.springpet.service.impl;

import by.svistunovvv.springpet.model.User;
import by.svistunovvv.springpet.repository.UserRepository;
import by.svistunovvv.springpet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void delete(String email) {
        repository.deleteUserByEmail(email);
    }
}
