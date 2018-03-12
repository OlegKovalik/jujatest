package com.jujatask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Oleg on 12.03.2018.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDataException extends RuntimeException {
    public UserDataException(String field) {
        super("Field " + field + " is empty!");
    }


}
