package com.boat.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


/**
 * @Author 李云鹏
 * @Date 2022/9/27 17:47
 * @Version 1.0
 */
@Data
public class Forecast {
    private Long id;//主键

    private BaseShip baseShip;//?????

    private String departPort;//始发港

    private String lastPort;//上一港

    private String nextPort;//下一港

    private String shipPoreArriveTime;//预抵时间

    private String shipPoreLeaveTime;//预离时间

    private String dock;//靠泊码头

    private String port;//靠泊泊位

    private String purpose;//来港目的

    private String goodsName;//货物名称

    private BigDecimal quantity;//货物数量

    private BigDecimal draftWater;//吃水

    private String updateTime;//更新时间
}