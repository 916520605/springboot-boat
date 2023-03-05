package com.boat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boat.entity.User;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/3/3 21:20
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return {@link User }
     * @author 李云鹏
     * @date 2023/03/03 21:27
     */
    User selectUserByNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
