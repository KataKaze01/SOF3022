package com.example.TS01135_java5OnTap.controller;

import com.example.TS01135_java5OnTap.entity.User;
import com.example.TS01135_java5OnTap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/index")
    public String viewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", service.findAll());
        return "user"; // user.jsp
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/user/index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/user/index";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        service.deleteById(id);
        return "redirect:/user/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", service.findById(id));
        model.addAttribute("users", service.findAll());
        return "user";
    }

    // 🔍 Tìm kiếm nâng cao
    @GetMapping("/search")
    public String search(@RequestParam(required = false) Integer id,
                         @RequestParam(required = false) String name,
                         Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", service.search(id, name));
        return "user";
    }
}
