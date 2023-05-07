package web.config.dao;

import org.springframework.stereotype.Component;
import web.config.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImp {
    //
    private static int People_COUNT;
    private List<User> people;
    {
        people = new ArrayList<>();
        people.add(new User(++People_COUNT, "User1", "User11", 20));
        people.add(new User(++People_COUNT, "User2", "User22", 21));
        people.add(new User(++People_COUNT, "User3", "User33", 22));
        people.add(new User(++People_COUNT, "User4", "User44", 23));
    }
    //получаем всех пользователей
    public List<User> index(){
        return people;
    }
    //ищем по id
    public User show(int id){
        return (User) people.stream().filter(people -> people.getId() == id ).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++People_COUNT);
        people.add(user);
    }


  //  public void update(int id, User updateUser) {
  public void update(int id, User updatedPerson) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setFirstName(updatedPerson.getFirstName());
        userToBeUpdated.setLastName(updatedPerson.getLastName());
      userToBeUpdated.setAge(updatedPerson.getAge());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId()==id);
    }
}
