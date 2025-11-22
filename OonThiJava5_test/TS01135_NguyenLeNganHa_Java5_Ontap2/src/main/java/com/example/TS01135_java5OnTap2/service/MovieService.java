package com.example.TS01135_java5OnTap2.service;

import com.example.TS01135_java5OnTap2.entity.Movie;
import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Integer id);
    Movie save(Movie movie); // Đổi User thành Movie
    void deleteById(Integer id);
    List<Movie> search(Integer id, String title); // Đổi name thành title
}
