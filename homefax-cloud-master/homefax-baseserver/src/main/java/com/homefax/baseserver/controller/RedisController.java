package com.homefax.baseserver.controller;

import com.homefax.baseserver.utils.RedisOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2018/12/29 15:01
 * @Create Author: nevermore
 * @File Name: RedisController
 * @Last version: 1.0.0
 */
@RestController
@Api(value="redis远程服务",tags={"redis远程服务"})
public class RedisController {

    @Autowired
    private RedisOperator redisOperator;

    @ApiOperation("这是一个redis操作示例")
    @PutMapping("/test1")
    public String test1(){
        redisOperator.set("2","6");
        return redisOperator.get("2");
    }
}
