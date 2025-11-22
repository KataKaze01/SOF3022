package poly.edu.controller;

import poly.edu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.service.userService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    userService service;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", service.findAll());
        return "user";
    }

    @PostMapping("/create")
    public String create(User user) {
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("user", service.findById(id));
        model.addAttribute("users", service.findAll());
        return "user";
    }

    @PostMapping("/update")
    public String update(User user) {
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/users";
    }
}
