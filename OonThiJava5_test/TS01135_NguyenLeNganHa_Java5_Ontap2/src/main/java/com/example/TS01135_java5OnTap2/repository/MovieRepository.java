package com.example.TS01135_java5OnTap2.repository;

import com.example.TS01135_java5OnTap2.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByMovieIDOrTitleContainingIgnoreCase(Integer id, String title);
}
