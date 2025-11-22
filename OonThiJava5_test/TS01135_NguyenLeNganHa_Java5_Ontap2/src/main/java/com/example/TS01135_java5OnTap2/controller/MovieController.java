package com.example.TS01135_java5OnTap2.controller;

import com.example.TS01135_java5OnTap2.entity.Movie;
import com.example.TS01135_java5OnTap2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies") // Đổi đường dẫn gốc thành /movies
public class MovieController {

    @Autowired
    private MovieService service; // Đổi service

    @GetMapping("/index")
    public String viewForm(Model model) {
        model.addAttribute("movie", new Movie()); // Đổi "user" thành "movie", new Movie()
        model.addAttribute("movies", service.findAll()); // Đổi "users" thành "movies"
        return "Index"; // Trả về view "movies.jsp"
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("movie") Movie movie) { // Đổi "user" thành "movie", kiểu Movie
        service.save(movie);
        return "redirect:/movies/index"; // Redirect về /movies/index
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("movie") Movie movie) { // Đổi "user" thành "movie", kiểu Movie
        service.save(movie); // JPA tự xử lý update nếu có ID
        return "redirect:/movies/index"; // Redirect về /movies/index
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) { // Giữ nguyên param "id"
        service.deleteById(id);
        return "redirect:/movies/index"; // Redirect về /movies/index
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) { // Giữ nguyên param "id"
        model.addAttribute("movie", service.findById(id)); // Đổi "user" thành "movie"
        model.addAttribute("movies", service.findAll()); // Đổi "users" thành "movies"
        return "Index"; // Trả về view "movies.jsp"
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) Integer id, // Param tìm kiếm là "id"
                         @RequestParam(required = false) String title, // Param tìm kiếm là "title"
                         Model model) {
        model.addAttribute("movie", new Movie()); // Đổi "user" thành "movie"
        model.addAttribute("movies", service.search(id, title)); // Đổi "users", gọi search với title
        return "Index"; // Trả về view "movies.jsp"
    }
}
