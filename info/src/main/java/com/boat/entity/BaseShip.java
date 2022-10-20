package com.boat.entity;

import com.boat.utils.CreateTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * @Author 李云鹏
 * @Date 2022/9/20 21:27
 * 船舶的基础信息
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseShip {
    private Long id; //主键

    private String shipName;//船名

    private String builtDate;//建成日期

    private String imo;//IMO号

    private String nationality;//国籍

    private BigDecimal grossTonnage;//总吨

    private BigDecimal netTons;//净吨

    private BigDecimal DWT;//载重吨

    private String homePort;//船籍港

    private String shipOwner;//船东

    private String callNumber;//呼号

    private String phoneNumber;//电话或海卫通

    private String length; //船长

    private String width; //船宽

    private String flag; //逻辑删除标识，1是未删，0是已删

    private String creatTime;//创建时间，排序字段

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BaseShip boat = new BaseShip();
        CreateTable createTable = new CreateTable();
        createTable.createTableUtils(boat,"t_baseShip");

    }
}
