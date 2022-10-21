package com.boat.utils;

/**
 * 状态
 *
 * @author 李云鹏
 * @description
 * @date 2022/10/21
 */
public enum Status {

    /**
     * 成功，系统异常，sql语句异常
     */
    OK(200, "请求成功"), SYSTEM_ERROR(101, "系统异常"), SQL_ERROR(109, "SQL语句异常");

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 错误信息
     */
    private final String message;

    /**
     * 构造器
     *
     * @param code 状态码
     * @param message 消息
     * @return
     * @author 李云鹏
     * @date 2022/10/21
     */
    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.code + ":" + this.message;
    }
}