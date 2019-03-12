package com.homefax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HomefaxEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomefaxEurekaApplication.class, args);
	}

}

