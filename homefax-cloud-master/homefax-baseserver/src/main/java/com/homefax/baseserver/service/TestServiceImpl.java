package com.homefax.baseserver.service;

import com.homefax.baseserver.dao.UserMapper;
import com.homefax.baseserver.utils.PageHelper;
import com.homefax.model.user.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findpage() {
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
