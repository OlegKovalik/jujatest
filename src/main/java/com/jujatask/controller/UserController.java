package com.jujatask.controller;

import com.jujatask.db.User;
import com.jujatask.exception.UserAlreadyExistException;
import com.jujatask.exception.UserDataException;
import com.jujatask.pojo.Response;
import com.jujatask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    @ResponseBody
    public Response<List<User>> getAllUsers() {
        List<User> userList = userService.findAll();

        if ((userList != null) && (userList.size() > 0)) {
            return new Response<>(1, userList);
        } else {
            return new Response<>(0, null);
        }
    }

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public Response<User> getAllUsers(@PathVariable(value = "id") long id) {
        User user = userService.findById(id);
        if (user != null) {
            return new Response<>(1, user);
        } else {
            return new Response<>(0, null);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user) {
        if (user == null) {
            throw new UserDataException("All");
        }
        if (user.getLogin().isEmpty()) {
            throw new UserDataException("login");
        }
        if (user.getFirstName().isEmpty()) {
            throw new UserDataException("firstname");
        }
        if (user.getLastName().isEmpty()) {
            throw new UserDataException("lastname");
        }

        if (userService.findByLogin(user.getLogin()) != null) {
            throw new UserAlreadyExistException(user.getLogin());
        }

        userService.save(user);

    }
    
}
