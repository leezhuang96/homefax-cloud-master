package com.homefax;

import com.homefax.baseserver.utils.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan(basePackages = "com.homefax.dao")
//扫描注解所在包以及其他模块基础类
@ComponentScan(basePackages = {"com.homefax.model.*", "com.homefax.baseserver"})
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages = "baseserver")
public class HomefaxBaseserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomefaxBaseserverApplication.class, args);
	}

}

