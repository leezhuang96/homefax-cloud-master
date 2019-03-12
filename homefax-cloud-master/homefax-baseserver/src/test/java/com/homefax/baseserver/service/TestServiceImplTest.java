package com.homefax.baseserver.service;

import com.homefax.baseserver.dao.UserMapper;
import com.homefax.model.user.User;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2018/12/26 10:29
 * @Create Author: nevermore
 * @File Name: TestServiceImplTest
 * @Last version: 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectMapper(){
        User user = new User();
        user.setUuid("1244");
        userMapper.selectAll();
        //userMapper.selectCount(user);
    }


}