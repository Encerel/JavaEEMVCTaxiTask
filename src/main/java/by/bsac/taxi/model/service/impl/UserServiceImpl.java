package by.bsac.taxi.model.service.impl;

import by.bsac.taxi.command.ParametersAndAttribute;
import by.bsac.taxi.entity.User;
import by.bsac.taxi.model.dao.UserDao;
import by.bsac.taxi.model.service.UserService;
import by.bsac.taxi.util.Encoder;
import by.bsac.taxi.validator.UserValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean addUser(Map<String, String> userData) {

        boolean isAdded = false;

        if (UserValidator.isValidEmail(userData.get(ParametersAndAttribute.EMAIL))
                && UserValidator.isValidName(userData.get(ParametersAndAttribute.USER_NAME))
                && UserValidator.isValidName(userData.get(ParametersAndAttribute.USER_SURNAME))
                && UserValidator.isValidPassword(userData.get(ParametersAndAttribute.USER_PASSWORD))) {

            String encodedPassword = Encoder.encodePassword(userData.get(ParametersAndAttribute.USER_PASSWORD));

            User user = new User.Builder().
                    setEmail(userData.get(ParametersAndAttribute.EMAIL))
                    .setName(userData.get(ParametersAndAttribute.USER_NAME))
                    .setRole(User.Role.USER)
                    .setSurname(userData.get(ParametersAndAttribute.USER_SURNAME))
                    .build();

           isAdded = userDao.addUser(user, encodedPassword);
        }

        return isAdded;
    }

    @Override
    public boolean changeUserRole(long id, User.Role role) {

        boolean isChanged = false;

        isChanged = userDao.changeRole(id, role);

        return isChanged;
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        Optional<User> userOptional = Optional.empty();



        if (UserValidator.isValidEmail(email)) {
            String encodedPassword = Encoder.encodePassword(password);

            Optional<String> passwordFromDataBaseOptional = userDao.findPasswordByEmail(email);

            if (passwordFromDataBaseOptional.isPresent()) {

                String passwordFromDB = passwordFromDataBaseOptional.get();
                if (passwordFromDB.equals(encodedPassword)) {
                    userOptional = userDao.findUserByEmail(email);
                }
            }
        }

        return userOptional;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> optionalUser = Optional.empty();

        if (UserValidator.isValidEmail(email)) {
           optionalUser = userDao.findUserByEmail(email);
        }
        return optionalUser;
    }
}
