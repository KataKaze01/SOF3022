package com.example.test.auth;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class AuthController {
    private final UserRepository userRepo;
    @GetMapping("/login")
    public String loginForm(){return "login";}

    @PostMapping("/login")
    public String login(@RequestParam String ten,@RequestParam String pass,HttpSession s,Model m){
        var u = userRepo.findByTen(ten).orElse(null);
        if(u==null || !u.getPass().equals(pass)){m.addAttribute("error","Sai");
            return "login";
        }
        s.setAttribute("user",u);
        return "redirect:/patient";
    }
}
