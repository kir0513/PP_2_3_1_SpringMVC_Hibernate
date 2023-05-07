package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.config.dao.UserDaoImp;
import web.config.model.User;

@Controller
@RequestMapping("/")
public class UserController {
    //
    //внедряем зависимость userDao в контроллер через конструктор

    private final UserDaoImp userDaoImp;

    public UserController(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    //метод возвращающий список пользователей. Здесь получаем всех людей из DAO и передаем их на отображение
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", userDaoImp.index());
        return "user/index";
    }

    //поиск пользователя по id из DAO и передаем на представление
    @GetMapping("user/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaoImp.show(id));
        return "user/show";
    }

    //метод, возвращающий html форму для создания нового пользователя
    @GetMapping("addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }
    //метод, принимающий Post запрос создающий пользователя и добавляющий его в БД
    @PostMapping("addUser")
    public String createNewUser(@ModelAttribute("user") User user) {
        userDaoImp.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDaoImp.show(id));
        return "user/edit";
    }

   @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDaoImp.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("user/{id}")
    public String delete(@PathVariable("id") int id) {
        userDaoImp.delete(id);
        return "redirect:/";
    }
}
