package com.boat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/3/3 18:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;

    private String userName;

    private String password;

}
