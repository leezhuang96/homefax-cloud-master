package com.homefax.api.config;

import com.homefax.api.interceptor.RequestInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 一些通用拦截器
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/22 14:10
 * @Create Author: nevermore
 * @File Name: InterceptorConfig
 * @Last version: version: 1.0.0
 */
@Configuration
@ComponentScan(value = "com.homefax.api")
public class InterceptorConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());
    }
}
