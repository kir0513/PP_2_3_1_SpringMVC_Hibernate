package web.service;

import org.springframework.stereotype.Repository;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Repository
public class UserServiceImp implements UserService{
    private final UserDao userDao;
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getSingleUserById(int id) {
        return userDao.getSingleUserById(id);
    }

    @Override
    public void update(User user){
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
