package com.boat.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 委托方
 *
 * @author 李云鹏
 * @version 1.0
 * @date 2022/11/5 9:31
 */
@Data
public class Delegation {

    /**
     * id
     */
    private Long id;
    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 组织机构代码
     */
    private String codeOfOrganization;
    /**
     * 公司性质
     */
    private Integer companyNature;
    /**
     * 联系人姓名
     */
    private String contactName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phoneNumber;
    /**
     * 启用状态(0启用，1禁用)
     */
    private Integer enableState;

    /**
     * 代理状态（0启用，1禁用）
     */
    private Integer agentState;
    /**
     * 船东状态（0启用，1禁用）
     */
    private Integer shipOwnerState;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
