package web.config.dao;

import org.springframework.stereotype.Component;
import web.config.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImp {
    //
    private List<User> user;
    {
        user = new ArrayList<>();
        user.add(new User(1, "User1", "User11", 20));
        user.add(new User(2, "User2", "User22", 21));
        user.add(new User(3, "User3", "User33", 22));
        user.add(new User(4, "User4", "User44", 23));
    }
    //получаем всех пользователей
    public List<User> index(){
        return user;
    }
    //ищем по id
    public User show(int id){
        return (User) user.stream().filter(user -> user.getId() == id ).findAny().orElse(null);
    }
}
