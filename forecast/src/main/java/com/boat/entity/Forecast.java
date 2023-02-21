package com.boat.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author 李云鹏
 * @date 2022/9/27 17:47
 * @version 1.0
 */
@Data
public class Forecast {
    /**
     * 主键
     */
    private Long id;
    /**
     * 基础船id
     */
    private Long baseShipId;

    /**
     * 船名
     */
    private String shipName;

    /**
     * imo号
     */
    private String imo;
    /**
     * 航次
     */
    private String voyage;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime poreArriveTime;

    /**
     * 预离时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime poreLeaveTime;

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

    /**
     * 拖轮
     */
    private String tug;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 代理
     */
    private String delegation;

}