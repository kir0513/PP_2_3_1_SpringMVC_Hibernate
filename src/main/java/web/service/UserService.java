package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void addUser(User user);

    User getSingleUserById(int id);

    void update(User user);

    void delete(int id);
}
