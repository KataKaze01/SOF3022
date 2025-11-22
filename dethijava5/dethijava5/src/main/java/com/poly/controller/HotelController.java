package com.poly.controller;

import com.poly.DAO.HotelDAO;
import com.poly.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HotelController {
    @Autowired
    HotelDAO dao;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("form", new Hotel());
        model.addAttribute("items", dao.findAll());
        return "index";
    }

    @PostMapping("/create")
    public String create(Hotel hotel) {
        dao.save(hotel);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("form", dao.findById(id).orElse(new Hotel()));
        model.addAttribute("items", dao.findAll());
        return "index";
    }

    @PostMapping("/update")
    public String update(Hotel hotel) {
        dao.save(hotel);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        dao.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("form", new Hotel());
        model.addAttribute("items", dao.search(keyword));
        return "index";
    }
}
