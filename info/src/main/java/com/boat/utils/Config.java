package com.boat.utils;

import lombok.Data;

/**
 * @Author 李云鹏
 * @Date 2022/9/20 12:39
 * @Version 1.0
 */
@Data
public class Config {
    private int id;
    private String driverClassName="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC" ;
    private String username="root";
    private String password="1234";

    //需要手动实现Config构造
    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

