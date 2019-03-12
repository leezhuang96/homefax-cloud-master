package com.homefax.baseserver.controller;

import com.homefax.baseserver.api.ApiInterface;
import com.homefax.baseserver.service.TestService;
import com.homefax.baseserver.utils.RedisOperator;
import com.homefax.model.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2018/12/21 14:40
 * @Create Author: nevermore
 * @File Name: TestController
 * @Last version: 1.0.0
 */

@RestController
@Api(value="测试使用controller",tags={"测试使用"})
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private ApiInterface apiInterface;

    @GetMapping("/test")
    public List<User> test(){
        logger.info("123");
        logger.error("456");
        logger.debug("789");
        return testService.findpage();
    }

    @GetMapping("/test2")
    public String test2(){
        return "这是baseserver远程服务";
    }

    @RequestMapping("/redis")
    public String redis(){
        //redisOperator.set("2","6");
        return redisOperator.get("2");
        //redisTemplate.opsForValue().set("1","2");
    }

    @RequestMapping("getApi")
    public String getApi(){
        return apiInterface.test();
    }

    @PostMapping("testSwagger")
    public String testSwagger(@RequestBody String name){
        return name;
    }

    /**
     * 测试对象传递swagger是否提示具体参数
     * @param user
     * @return
     */
    @ApiOperation("测试对象传递swagger是否提示具体参数")
    @PostMapping("testBean")
    public String testBean(@RequestBody User user){
        return user.toString();
    }

}
