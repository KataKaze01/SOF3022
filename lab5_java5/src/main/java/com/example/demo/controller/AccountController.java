package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.CookieService;
import com.example.demo.service.ParamService;
import com.example.demo.service.SessionService;

@Controller
public class AccountController {
    @Autowired
    ParamService paramService;

    @Autowired
    CookieService cookieService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1(Model model) {
        String username = cookieService.getValue("user");
        model.addAttribute("username", username);
        return "/account/login";
    }


    @PostMapping("/account/login")
    public String login2() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if ("poly".equals(username) && "123".equals(password)) {
            sessionService.set("username", username);
            if (remember) {
                cookieService.add("user", username, 240); // 10 ngày
            } else {
                cookieService.remove("user");
            }
            return "redirect:/item/index";
        }

        return "/account/login";
    }
}

