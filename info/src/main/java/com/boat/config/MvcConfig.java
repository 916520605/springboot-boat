package com.boat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.boat.utils.MyInterceptor;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/1/4 21:34
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/user/login"
        // 除了登录，其他全部拦截
        );
    }
}
