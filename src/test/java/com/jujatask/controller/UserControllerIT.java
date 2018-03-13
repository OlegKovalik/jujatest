package com.jujatask.controller;

import com.jujatask.Application;
import com.jujatask.dao.UserDao;
import com.jujatask.db.User;
import com.jujatask.pojo.Response;
import com.jujatask.pojo.UserTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest

public class UserControllerIT {
    private RestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private UserDao userDao;

    @Before

    public void setUp() throws Exception {
        userDao.deleteAll();
        userDao.save(User.builder().login("test1").password("qwerty").firstName("Test1").lastName("Test1").build());
        userDao.save(User.builder().login("test2").password("asdfg").firstName("Test1").lastName("Test2").build());
    }


    @Test
    public void getAllUsers() throws Exception {
        ResponseEntity<Response<List<User>>> responseEtity = restTemplate.exchange("http://localhost:8083/user", HttpMethod.GET, null, new ParameterizedTypeReference<Response<List<User>>>() {
        });

        Response<List<User>> response = responseEtity.getBody();
        assertThat(response.getSuccess(), is(1));
        assertThat(response.getData().size(), is(2));
        List<String> loginList = response.getData().stream().map(a -> a.getLogin()).collect(Collectors.toList());
        assertThat(loginList, containsInAnyOrder("test1", "test2"));


    }


    @Test
    public void saveUser() throws Exception {

        HttpEntity<UserTest> entity = new HttpEntity<>(new UserTest("test3", "zxcvb", "Test3", "Test3"));
        ResponseEntity<String> responseEtity = restTemplate.exchange("http://localhost:8083/user", HttpMethod.POST, entity, String.class);
        assertThat(responseEtity.getStatusCode(), is(HttpStatus.CREATED));
        assertTrue(userDao.findByLogin("test3").isPresent());

    }

    @Test
    public void getUser() throws Exception {

        ResponseEntity<Response<User>> responseEtity = restTemplate.exchange("http://localhost:8083/user/" + userDao.findByLogin("test2").get().getId(), HttpMethod.GET, null, new ParameterizedTypeReference<Response<User>>() {
        });

        Response<User> response = responseEtity.getBody();

        assertThat(response.getSuccess(), is(1));
        assertThat(response.getData().getLogin(), is("test2"));
    }

}