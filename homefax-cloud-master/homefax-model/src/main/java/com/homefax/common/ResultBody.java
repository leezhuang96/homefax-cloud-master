package com.homefax.common;

import com.homefax.Enum.ResultEnum;

import java.io.Serializable;

/**
 * @Description:
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/22 9:42
 * @Create Author: nevermore
 * @File Name: ResultBody
 * @Last version: 1.0.0
 */
public class ResultBody implements Serializable{

    private String status;

    private String msg;

    private Object date;

    public ResultBody() {
    }

    public ResultBody(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultBody(String status, String msg, Object date) {
        this.status = status;
        this.msg = msg;
        this.date = date;
    }

    public ResultBody(ResultEnum resultEnum){
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMsg();
    }

    public ResultBody(ResultEnum resultEnum, Object data){
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMsg();
        this.date = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
