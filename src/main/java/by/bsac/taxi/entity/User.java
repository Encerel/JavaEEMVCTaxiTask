package by.bsac.taxi.entity;

import java.util.Objects;

public class User {

    private long userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;

    public enum Role {
        USER,
        ADMIN
    }

    private User(){}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, email, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public static class Builder {

        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setId(long id) {
            newUser.userId = id;
            return this;
        }

        public Builder setName(String name) {
            newUser.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            newUser.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public Builder setRole(Role role) {
            newUser.role = role;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
