package com.homefax.api.controller;


import com.homefax.Enum.ResultEnum;
import com.homefax.annotation.LoginCheck;
import com.homefax.api.BaseServer.BaseServerInterface;
import com.homefax.api.service.TestService;
import com.homefax.api.vo.UserVo;
import com.homefax.common.ResultBody;
import com.homefax.exception.HomefaxException;
import com.homefax.model.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
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
@Api(value="信易贷接口",tags={"信易贷接口操作说明"})
@RefreshScope
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private BaseServerInterface baseServerInterface;

    @Autowired
    private TestService testService;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${env}")
    private String env;


    @ApiOperation("这是一个被baseServer调用的示例")
    @GetMapping("/test")
    public String test5(){
        return "这是远程api服务";
    }

    @ApiOperation("这是一个远程调用baseServer服务的示例，同时是swagger方法说明示例")
    @GetMapping("/getBaseServer")
    public String getBaseServer(){
        return baseServerInterface.test2();
    }

    @ApiOperation("这是一个访问数据库示例")
    @GetMapping("/findByPage")
    public List<User> findByPage(){
        return testService.findByPage();
    }

    @LoginCheck
    @ApiOperation("这是一个自定义异常抛出测试")
    @GetMapping("/testException")
    public ResultBody testException(){
        logger.info(profile);
        throw new HomefaxException(ResultEnum.login_error);
       // return new ResultBody(ResultEnum.success);
    }

    /**
     * 启动是指定环境 java -jar ***.jar --spring.profiles.active=prod
     * @return
     */
    @ApiOperation("这是一个读取配置文件打包测试方法")
    @GetMapping("testPackage")
    public String testPackage(){
        return profile;
    }

    @ApiOperation("这是一个传递对象的方法")
    @PostMapping("save")
    public String saveUser(@RequestBody User user){
        System.out.println(user.toString());
        return user.toString();
    }

    /**
     *  修改远程配置后需要手动刷新，刷新地址为ip:port/actuator/refresh,post请求
     */
    @ApiOperation("这是加载远程配置文件的示例,")
    @GetMapping("getEnv")
    public String getEnv() {
        return env;
    }

    @ApiOperation("这是一个表单验证接口,")
    @PostMapping("saveUserVo")
    public String getUserVo(@Valid  @RequestBody UserVo userVo) {
        return userVo.toString();
    }

}
