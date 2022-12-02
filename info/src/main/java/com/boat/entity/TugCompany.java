package com.boat.entity;

import lombok.Data;

/**
 * @author 李云鹏
 * @date 2022/10/30 5:43
 * @version 1.0
 */

@Data
public class TugCompany {
    /**
     * 名字标识
     */
    private Long tugCompanyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司代码
     */
    private String companyCode;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 创造时间
     */
    private String creatTime;
}