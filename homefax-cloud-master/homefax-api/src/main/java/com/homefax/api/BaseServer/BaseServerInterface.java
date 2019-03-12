package com.homefax.api.BaseServer;


import com.homefax.model.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "homefax-baseserver")
public interface BaseServerInterface {

    @RequestMapping("/test2")
    String test2();

}
