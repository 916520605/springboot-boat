package com.boat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 引航站
 *
 * @author 李云鹏
 * @description
 * @date 2022/10/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PilotStation {
    /**
     * 主键
     */
    private Long id;
    /**
     * 引航站名字
     */
    private String name;

    /**
     * 助记码
     */
    private String helpCode;
}
