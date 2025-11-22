package com.example.TS01135_java5OnTap.service.impl;

import com.example.TS01135_java5OnTap.entity.User;
import com.example.TS01135_java5OnTap.repository.UserRepository;
import com.example.TS01135_java5OnTap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    // 🔍 Tìm kiếm nâng cao
    @Override
    public List<User> search(Integer id, String name) {
        if ((id == null || id == 0) && (name == null || name.isEmpty())) {
            return repo.findAll();
        }
        return repo.findByIdOrNameContainingIgnoreCase(id, name);
    }
}
