package com.homefax.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


//扫描注解所在包以及其他模块基础类
@ComponentScan(basePackages = {"com.homefax.model.*", "com.homefax.api"})
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class HomefaxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomefaxApiApplication.class, args);
    }

}
