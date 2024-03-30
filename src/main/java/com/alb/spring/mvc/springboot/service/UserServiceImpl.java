package com.alb.spring.mvc.springboot.service;

import com.alb.spring.mvc.springboot.DAO.UserDAO;
import com.alb.spring.mvc.springboot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public List<User> getUserTable() {
        return userDAO.getUserTable();
    }

    @Override
    public User findUser(long id) {
        return userDAO.findUser(id);
    }
}
