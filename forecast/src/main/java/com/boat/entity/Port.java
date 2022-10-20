package com.boat.entity;

import lombok.Data;

/**
 * @Author 李云鹏
 * @Date 2022/10/1 0:41
 * @Version 1.0
 */

/**
 * 泊位表
 * 
 * @author Administrator
 */
@Data
public class Port {
    /**
     * 主键id
     */
    private Long id;

    private String dockId;

    private String portName;

    private String portCode;

    private String portDraft;
}