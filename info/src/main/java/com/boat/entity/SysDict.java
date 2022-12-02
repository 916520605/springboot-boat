package com.boat.entity;

import lombok.Data;

/**
 * @author 李云鹏
 * @date 2022/11/8 12:12
 * @version 1.0
 */
@Data
public class SysDict {
    private Long id;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态(0启用1停用)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private String createTime;

    private String starTime;

    private String endTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 字典类型
     */
    private String type;
}