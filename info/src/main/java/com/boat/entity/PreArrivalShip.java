package com.boat.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreArrivalShip {
    private Long id; // 主键

    private String shipName;// 船名

    private String shipNumber;// 航次

    private String builtDate;// 建成日期

    private String shipPoreArriveTime;// 预抵时间

    private String shipPoreLeaveTime;// 预离时间

    private String port;// 靠泊码头

    private String goodsName;// 装载货物名称

    private String unit;// 单位

    private BigDecimal quantity;// 货物重量

    private String imo;// IMO号

    private String nationality;// 国籍

    private BigDecimal grossTonnage;// 总吨

    private BigDecimal netTons;// 净吨

    private BigDecimal DWT;// 载重吨

    private String homePort;// 船籍港

    private String shipOwner;// 船东

    private String callNumber;

    private String phoneNumber;// 电话或海卫通

    private String length;

    private String width;

    private String draftWater;

}