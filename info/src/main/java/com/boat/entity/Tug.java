package com.boat.entity;

import lombok.Data;

/**
 * @Author 李云鹏
 * @Date 2022/10/30 5:04
 * @Version 1.0
 */

/**
 * tug
 * 
 * @author Administrator
 */
@Data
public class Tug {
    /**
     * 拖船id
     */
    private Long tugId;

    /**
     * 拖轮名字
     */
    private String tugName;

    /**
     * 拖船代码
     */
    private String tugCode;

    /**
     * 拖轮公司id
     */
    private Long tugCompanyId;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 创造时间
     */
    private String creatTime;
}