package com.example.TS01135_java5.controller;

import com.example.TS01135_java5.entity.Flights;
import com.example.TS01135_java5.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@Controller
@RequestMapping("/flights")
public class FlightsController {

    @Autowired
    private FlightsService service;

    @GetMapping("/index")
    public String viewForm(Model model) {
        model.addAttribute("flight", new Flights());
        model.addAttribute("flights", service.findAll());
        return "Index";
    }

    @GetMapping("/reset")
    public String resetForm() {
        return "redirect:/flights/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("flight") Flights flight) {
        // (Bỏ qua logic gán ngày vì form đã có input datetime-local)
        service.save(flight);
        return "redirect:/flights/index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("flight") Flights flight) {
        service.save(flight);
        return "redirect:/flights/index";
    }

    // *** SỬA LẠI PHƯƠNG THỨC DELETE ***
    @PostMapping("/delete")
    public String delete(
            // 'id' này là từ nút "Remove" trong file FlightsList.jsp
            @RequestParam(name = "id", required = false) Integer idFromList,

            // 'flight' này là từ nút "Delete" mới trên file FlightsForm.jsp
            @ModelAttribute("flight") Flights flightFromForm
    ) {

        Integer idToDelete = null;

        if (idFromList != null) {
            // 1. Nếu người dùng nhấn "Remove" trong danh sách
            idToDelete = idFromList;
        } else if (flightFromForm != null && flightFromForm.getFlightID() != null) {
            // 2. Nếu người dùng nhấn "Delete" trên form
            idToDelete = flightFromForm.getFlightID();
        }

        // Nếu tìm thấy ID từ một trong hai nguồn, thì xóa
        if (idToDelete != null) {
            service.deleteById(idToDelete);
        }

        return "redirect:/flights/index";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("flight", service.findById(id));
        model.addAttribute("flights", service.findAll());
        return "Index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) Integer id,
                         @RequestParam(required = false) String airline,
                         Model model) {
        model.addAttribute("flight", new Flights());
        model.addAttribute("flights", service.search(id, airline));
        return "Index";
    }
}