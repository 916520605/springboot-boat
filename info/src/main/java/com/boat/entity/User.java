package com.boat.entity;

import lombok.Data;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/1/4 21:24
 */
@Data
public class User {

    private Long id;

    private String userName;

    private String password;

    private String phoneNumber;

    private String emailAddress;

}
