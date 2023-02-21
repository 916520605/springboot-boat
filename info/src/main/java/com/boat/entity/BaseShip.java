package com.boat.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 李云鹏
 * @Date 2022/9/20 21:27 船舶的基础信息
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class BaseShip {
    /**
     * id主键
     */
    private Long id;

    /**
     * 船名
     */
    private String shipName;

    /**
     * 建立日期
     */
    private String builtDate;

    /**
     * IMO号
     */
    private String imo;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 总吨位
     */
    private BigDecimal grossTonnage;

    /**
     * 净吨
     */
    private BigDecimal netTons;

    /**
     * 载重吨
     */
    private BigDecimal DWT;

    /**
     * 船籍港
     */
    private String homePort;

    /**
     * 船东
     */
    private String shipOwner;

    /**
     * 呼号
     */
    private String callNumber;

    /**
     * // 电话或海卫通
     */
    private String phoneNumber;

    /**
     * 船长
     */
    private String length;

    /**
     * 船宽
     */
    private String width;

    /**
     * 逻辑删除标识，1是未删，0是已删
     */
    private String flag;

    /**
     * 创建时间，排序字段
     */
    private String creatTime;
    /**
     * 电子邮件地址
     */
    private String emailAddress;

    /**
     * 船舶性质
     */
    private String shipNature;

}
