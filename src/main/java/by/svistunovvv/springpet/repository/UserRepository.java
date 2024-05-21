package by.svistunovvv.springpet.repository;

import by.svistunovvv.springpet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    void deleteUserByEmail(String email);
}
