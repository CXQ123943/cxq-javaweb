package com.steven.work.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private String username;
    private String password;
}
