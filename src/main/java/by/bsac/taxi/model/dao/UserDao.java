package by.bsac.taxi.model.dao;

import by.bsac.taxi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> findAll();

    boolean addUser(User user, String password);

    boolean changeRole(long id, User.Role role);

    Optional<String> findPasswordByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
