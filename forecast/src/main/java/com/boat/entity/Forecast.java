package com.boat.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @Author 李云鹏
 * @Date 2022/9/27 17:47
 * @Version 1.0
 */
@Data
public class Forecast {
    /**
     * 主键
     */
    private Long id;

    /**
     * 船名
     */
    private String shipName;

    /**
     * imo号
     */
    private String imo;

    /**
     * 始发港
     */
    private String departPort;

    /**
     * 上一港
     */
    private String lastPort;

    /**
     * 下一港
     */
    private String nextPort;

    /**
     * 预抵时间
     */
    private String poreArriveTime;

    /**
     * 预离时间
     */
    private String poreLeaveTime;

    /**
     * 靠泊码头
     */
    private String dock;

    /**
     * 靠泊泊位
     */
    private String port;

    /**
     * 来港目的
     */
    private String purpose;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 货物数量
     */
    private BigDecimal quantity;

    /**
     * 吃水
     */
    private BigDecimal draftWater;

    /**
     * 引航站
     */
    private String pilotStation;

    /**
     * 拖轮公司
     */
    private String tugCompany;
}