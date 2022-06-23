package com.xiaoxiao.entity;

import lombok.Data;

/**
 * @author xiaoxiao
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
