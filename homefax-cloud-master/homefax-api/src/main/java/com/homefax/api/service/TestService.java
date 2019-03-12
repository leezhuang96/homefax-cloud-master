package com.homefax.api.service;

import com.homefax.model.user.User;

import java.util.List;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/21 14:00
 * @Create Author: nevermore
 * @File Name: TestService
 * @Last version: 1.0.0
 */
public interface TestService {

    List<User> findByPage();
}
