package com.homefax.baseserver.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "homefax-api")
public interface ApiInterface {

    @RequestMapping("/test")
    String test();
}
