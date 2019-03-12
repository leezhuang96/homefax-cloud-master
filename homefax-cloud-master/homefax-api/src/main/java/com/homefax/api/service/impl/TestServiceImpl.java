package com.homefax.api.service.impl;

import com.homefax.api.dao.UserMapper;
import com.homefax.api.service.TestService;
import com.homefax.common.PageHelper;
import com.homefax.model.user.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/21 14:01
 * @Create Author: nevermore
 * @File Name: TestServiceImpl
 * @Last version: 1.0.0
 */

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findByPage() {
            List<User> list = userMapper.selectAll();
            System.out.println(userMapper.selectCount(null));
            User user = new User();
            user.setUuid("1244");
            System.out.println(userMapper.selectCount(user));
            RowBounds rowBounds = new RowBounds(0,10);
            PageHelper pageHelper = new PageHelper();
            list = userMapper.selectByRowBounds(null,pageHelper);
            return list;
    }
}
