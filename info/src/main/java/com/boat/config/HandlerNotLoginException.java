package com.boat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import com.boat.utils.Result;

import cn.dev33.satoken.exception.NotLoginException;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/3/4 21:12
 */
@Configuration
@ControllerAdvice(annotations = {RestController.class, CrossOrigin.class, RequestMapping.class})
@ResponseBody
public class HandlerNotLoginException {

    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler({NotLoginException.class})
    public Result handlerNotLoginException(NotLoginException nle) throws Exception {

        // 打印堆栈，以供调试
        nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        int code;
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
            code = 100;
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
            code = 101;
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
            code = 102;
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
            code = 103;
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
            code = 104;
        } else {
            message = "当前会话未登录";
            code = 105;
        }
        System.out.println(message);
        // 返回给前端
        return Result.buildR(message, code);
    }

}
