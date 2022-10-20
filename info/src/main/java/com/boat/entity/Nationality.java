package com.boat.entity;

import lombok.Data;


/**
 * @Author 李云鹏
 * @Date 2022/9/22 19:21
 * @Version 1.0
 */
@Data
public class Nationality {
    private Long id;

    private String numberCode;//数字编码

    private String letterCode;//字母编码

    private String countryName;//国家名称
}