package com.homefax.exception;

import com.homefax.Enum.ResultEnum;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/22 10:37
 * @Create Author: nevermore
 * @File Name: HomefaxException
 * @Last version: 1.0.0
 */
public class HomefaxException extends RuntimeException {

    private String status;

    public HomefaxException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.status = resultEnum.getStatus();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
