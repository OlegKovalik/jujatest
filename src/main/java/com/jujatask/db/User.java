package com.jujatask.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Oleg on 12.03.2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false, length = 30)
    private String login;
    @JsonIgnore
    @Column(nullable = false, length = 50)
    private String password;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;


}
