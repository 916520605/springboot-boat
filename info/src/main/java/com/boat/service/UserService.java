package com.boat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boat.entity.User;
import com.boat.mapper.UserMapper;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/3/3 21:36
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public SaResult selectUser(User user) {
        User user1 = this.userMapper.selectUserByNameAndPassword(user.getUserName(), user.getPassword());
        boolean empty = ObjectUtils.isEmpty(user1);
        if (empty) {
            return SaResult.code(403);
        }
        // 判断当前会话是否已登录
        boolean login = StpUtil.isLogin();
        // 如果是false，表示没登录，那就登录
        if (!login) {
            // 如果登录成功，创建一个token
            StpUtil.login(user1.getId());
            // 拿到token并返回给前台
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
        // true，表示已登录， 如果已登录，判断token的有效性
        long tokenTimeout = StpUtil.getTokenTimeout();
        if (tokenTimeout <= 0) {
            // 先注销当前会话，
            StpUtil.logout();
            // 再重新生成token
            StpUtil.login(user1.getId());
            // 拿到token并返回给前台
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
        // tokenTimeout>0,表示token依然可用
        return SaResult.data(StpUtil.getTokenInfo());
    }
}
