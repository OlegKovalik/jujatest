package com.jujatask.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Oleg on 12.03.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int success = 1;
    private T data;
}
