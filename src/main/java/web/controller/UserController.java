package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.config.dao.UserDaoImp;

@Controller
@RequestMapping("/")
public class UserController {
    //внедряем зависимость userDao в контроллер через конструктор
    private final UserDaoImp userDaoImp;

    public UserController(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    //метод возвращающий список пользователей. Здесь получаем всех людей из DAO и передаем их на отображение
    @GetMapping()
    public String index(Model model){
        model.addAttribute("user", userDaoImp.index());
        return "user/index";
    }

    //поиск пользователя по id из DAO и передаем на представление
    @GetMapping("/{id}")
    public  String show(@PathVariable("/id") int id, Model model){
        model.addAttribute("user", userDaoImp.show(id));
        return  "user/show";
    }
}
