package com.example.test.patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    private final PatientRepository patientRepo;

    @GetMapping
    public String list(Model m, @RequestParam(required = false) String key) {
        m.addAttribute("patients", key == null ? patientRepo.findAll() : patientRepo.findByIdContainingOrFirstnameContainingOrLastnameContaining(key, key, key));
        m.addAttribute("patient", new Patient());
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Patient patient) {
        patientRepo.save(patient);
        return "redirect:/patient";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model m) {
        m.addAttribute("patient", patientRepo.findById(id).orElse(new Patient()));
        m.addAttribute("patients", patientRepo.findAll());
        m.addAttribute("editing", true);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        patientRepo.deleteById(id);
        return "redirect:/patient";
    }
}
//http://localhost:8080/patient