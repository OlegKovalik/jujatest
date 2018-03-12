package com.jujatask;

import com.jujatask.db.User;
import com.jujatask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Oleg on 12.03.2018.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        userService.save(User.builder().login("Oleg").password("qwerty").firstName("Oleg").lastName("Kovalyk").build());
        userService.save(User.builder().login("Danil").password("asdfg").firstName("Danil").lastName("Kuznetsov").build());

    }
}
