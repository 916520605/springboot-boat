package com.boat.utils;

import lombok.Data;

/**
 * 结果
 *
 * @author 李云鹏
 * @description 通用返回类型
 * @date 2022/10/21
 */
@Data
public class Result<T> {
    private int code;
    // 状态码
    private Integer status;
    // 错误的状态信息
    private String message;
    // 数据
    private T data;

    /**
     * 构造器(私有化)，这里写了3个构造器。根据实际发开需要添加即可
     */
    private Result(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private Result(String message) {
        this.message = message;
    }

    private Result(String message, T data) {
        this.message = message;
        this.data = data;
    }

    private Result(String message, int code) {
        this.message = message;
        this.code = code;
    }

    // 下面就是根据需要返回不同参数格式的方法
    /**
     * 返回《状态码》《状态信息》《数据》 状态码来自--->>枚举 状态信息来自--->>开发人员 数据来自--->>开发人员
     */
    public static <T> Result<T> buildR(Status status, String message, T data) {
        return new Result<T>(status.getCode(), message, data);

    }

    /**
     * 返回《状态码》《状态信息》《状态信息》 状态码来自--->>枚举 状态信息来自--->>开发人员
     */
    public static <T> Result<T> buildR(Status status, String message) {
        return new Result<T>(status.getCode(), message);
    }

    /**
     * 返回《状态码》《状态信息》《数据》 状态码来自--->>枚举 状态信息来自--->>枚举 数据来自--->>开发人员
     */
    public static <T> Result<T> buildR(Status status, T data) {
        return new Result<T>(status.getCode(), status.getMessage(), data);
    }

    /**
     * 返回《状态码》《状态信息》《数据》 状态码来自--->>枚举 状态信息来自--->>枚举 数据来自--->>开发人员
     */
    public static <T> Result<T> buildR(Status status) {
        return new Result<T>(status.getCode(), status.getMessage());
    }

    public static <T> Result<T> buildR(String message) {
        return new Result<T>(message);
    }

    public static <T> Result<T> buildR(String message, int code) {
        return new Result<T>(message, code);
    }

    public static <T> Result<T> buildR(String message, T data) {
        return new Result<T>(message, data);
    }
}
