package com.wxiaoy.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @author Alex Yu
 * @date 2019/11/29 18:33
 */
@Configuration
public class SessionInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns(Arrays.asList("/tologin", "toreg", "/login", "/checkaccount", "/reg"));
    }
}
