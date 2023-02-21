package com.boat.entity;

import lombok.Data;

/**
 * @author 李云鹏
 * @date 2022/11/11 11:31
 * @version 1.0
 */
@Data
public class SysDictItem {
    private Long id;

    /**
     * 字典id
     */
    private Long dictId;

    /**
     * 类型
     */
    private String type;
    /**
     * 字典项文本
     */
    private String itemText;

    /**
     * 字典项值
     */
    private String itemValue;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sortOrder;

    /**
     * 状态（0启用 1不启用）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}