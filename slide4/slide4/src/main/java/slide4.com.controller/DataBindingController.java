package slide4.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import slide4.com.entity.Student;

@Controller
public class DataBindingController {
    @GetMapping("/student/form")
    public String showForm(Model model, @ModelAttribute("student") Student student) {
        model.addAttribute("message", "Enter student info please!");
        return "/demo/student";
    }

    @PostMapping("/student/save")
    public String saveStudent(Model model, @ModelAttribute("student") Student student) {
        model.addAttribute("message", "Student saved successfully!");
        return "/demo/student";
    }
}
