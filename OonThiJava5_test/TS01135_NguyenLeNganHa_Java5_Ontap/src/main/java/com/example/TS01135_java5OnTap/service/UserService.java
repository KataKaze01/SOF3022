package com.example.TS01135_java5OnTap.service;

import com.example.TS01135_java5OnTap.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    void deleteById(Integer id);

    // 🔍 Tìm kiếm nâng cao
    List<User> search(Integer id, String name);
}
