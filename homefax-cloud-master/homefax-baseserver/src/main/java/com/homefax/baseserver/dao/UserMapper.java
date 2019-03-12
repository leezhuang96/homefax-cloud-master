package com.homefax.baseserver.dao;

import com.homefax.baseserver.utils.MyMapper;
import com.homefax.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}