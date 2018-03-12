package com.jujatask.service;

import com.jujatask.dao.UserDao;
import com.jujatask.db.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Oleg on 12.03.2018.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findOne(id);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }

}
