package com.jujatask.controller;

import com.jujatask.db.User;
import com.jujatask.pojo.Response;
import com.jujatask.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    UserController sut;

    @Before
    public void setUp() throws Exception {
        when(userService.findAll()).thenReturn(new ArrayList<User>(Arrays
                .asList(User.builder().login("test").password("pwd").firstName("Test1").lastName("Test2").build())));


    }

    @Test
    public void getAllUsers() throws Exception {

        Response<List<User>> response = sut.getAllUsers();

        verify(userService).findAll();

    }

    @Test
    public void getAllUsersData() throws Exception {

        Response<List<User>> response = sut.getAllUsers();


        assertThat(response.getSuccess(), is(1));
        assertThat(response.getData().size(), is(1));
        assertThat(response.getData().get(0).getLogin(), is("test"));

    }


}