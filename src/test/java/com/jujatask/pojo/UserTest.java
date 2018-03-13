package com.jujatask.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jujatask.db.User;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor



public class UserTest extends User {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String password;


    public UserTest(String login, String password, String firstName, String lastName) {
        super(login, firstName, lastName);
        this.password = password;
    }
}
