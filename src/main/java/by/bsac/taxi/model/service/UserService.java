package by.bsac.taxi.model.service;

import by.bsac.taxi.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    boolean addUser(Map<String, String> userData);

    boolean changeUserRole(long id, User.Role role);

    Optional<User> findUserByEmailAndPassword(String email, String password);

    Optional<User> findUserByEmail(String email);
}
