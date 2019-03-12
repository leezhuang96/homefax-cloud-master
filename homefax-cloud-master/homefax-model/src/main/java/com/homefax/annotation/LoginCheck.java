package com.homefax.annotation;

import java.lang.annotation.*;

/**
 * @Description: 是否做登录校验
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/22 10:08
 * @Create Author: nevermore
 * @File Name: ResultEnum
 * @Last version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginCheck {
}

