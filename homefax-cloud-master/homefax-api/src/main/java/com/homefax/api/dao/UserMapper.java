package com.homefax.api.dao;

import com.homefax.common.MyMapper;
import com.homefax.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}