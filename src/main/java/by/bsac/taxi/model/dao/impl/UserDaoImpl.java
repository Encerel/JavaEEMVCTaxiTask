package by.bsac.taxi.model.dao.impl;

import by.bsac.taxi.entity.User;
import by.bsac.taxi.model.connection.ConnectionCreator;
import by.bsac.taxi.model.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.bsac.taxi.model.dao.ColumnName.*;


public class UserDaoImpl implements UserDao {

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM \"user\"";
    private static final String SQL_ADD_USER = "INSERT INTO \"user\" (\"name\", surname, email, \"password\",\"role\") VALUES (?, ?, ?, ?, CAST(? AS user_role))";
    private static final String SQL_CHANGE_USER_ROLE = "UPDATE \"user\" SET role=CAST(? AS user_role) WHERE user_id=?";
    private static final String SQL_FIND_PASSWORD_BY_EMAIL = "SELECT password FROM \"user\" WHERE email=?";
    private static final String SQL_FIND_USER_BY_EMAIL = "SELECT user_id, name, surname, email, role FROM \"user\" WHERE email=?";


    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionCreator.getInstance()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_USERS);

            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean addUser(User user, String password) {

        boolean isAdded = false;
        try (Connection connection = ConnectionCreator.getInstance()) {

            PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, password);
            statement.setString(5, user.getRole().toString());
            int rowCount = statement.executeUpdate();

            if (rowCount != 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean changeRole(long id, User.Role role) {

        boolean isChanged = false;

        try (Connection connection = ConnectionCreator.getInstance()) {
            PreparedStatement statement = connection.prepareStatement(SQL_CHANGE_USER_ROLE);
            statement.setString(1, role.name());
            statement.setLong(2, id);
            int rowCount = statement.executeUpdate();

            if (rowCount != 0) {
                isChanged = true;
            } else {
                throw new SQLException("exception in change role userDao");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isChanged;
    }

    @Override
    public Optional<String> findPasswordByEmail(String email) {
        Optional<String> optionalPassword = Optional.empty();
        String password = null;
        try (Connection connection = ConnectionCreator.getInstance()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_PASSWORD_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString(PASSWORD);
                optionalPassword = Optional.of(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalPassword;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {

        Optional<User> userOptional = Optional.empty();

            try (Connection connection = ConnectionCreator.getInstance()) {
                PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_EMAIL);
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    User user = buildUser(resultSet);
                    userOptional = Optional.of(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return userOptional;
    }

    private User buildUser(ResultSet resultSet) throws SQLException {

        long userId = resultSet.getLong(ID_USER);
        String username = resultSet.getString(USER_NAME);
        String surname = resultSet.getString(USER_SURNAME);
        String email = resultSet.getString(EMAIL);
        User.Role role = User.Role.valueOf(resultSet.getString(ROLE).toUpperCase());

        User user = new User.Builder()
                .setId(userId)
                .setName(username)
               .setSurname(surname)
               .setEmail(email)
               .setRole(role)
               .build();

        return user;
    }
}
