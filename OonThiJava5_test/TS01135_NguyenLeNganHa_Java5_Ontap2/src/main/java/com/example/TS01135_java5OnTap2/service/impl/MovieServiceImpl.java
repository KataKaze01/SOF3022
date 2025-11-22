package com.example.TS01135_java5OnTap2.service.impl;

import com.example.TS01135_java5OnTap2.entity.Movie;
import com.example.TS01135_java5OnTap2.repository.MovieRepository;

import com.example.TS01135_java5OnTap2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService { // Implement MovieService

    @Autowired
    private MovieRepository repo; // Đổi kiểu repo

    @Override
    public List<Movie> findAll() {
        return repo.findAll();
    }

    @Override
    public Movie findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Movie save(Movie movie) { // Đổi User thành Movie
        return repo.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Movie> search(Integer id, String title) { // Đổi name thành title
        // Kiểm tra nếu cả id và title đều không hợp lệ (null, 0 hoặc rỗng) thì trả về tất cả
        if ((id == null || id == 0) && (title == null || title.trim().isEmpty())) {
            return repo.findAll();
        }
        // Nếu id hợp lệ nhưng title không thì chỉ tìm theo id (hoặc ngược lại)
        // Hoặc tìm kết hợp cả hai nếu cả hai đều có giá trị
        // Phương thức của JpaRepository xử lý tốt trường hợp một trong hai là null
        return repo.findByMovieIDOrTitleContainingIgnoreCase(id, title);
    }
}
