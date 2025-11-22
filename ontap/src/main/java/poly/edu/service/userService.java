package poly.edu.service;

import poly.edu.DAO.UserDAO;
import poly.edu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    UserDAO dao;

    public List<User> findAll() {
        return dao.findAll();
    }

    public User findById(String id) {
        return dao.findById(id).orElse(null);
    }

    public User save(User user) {
        return dao.save(user);
    }

    public void deleteById(String id) {
        dao.deleteById(id);
    }
}
