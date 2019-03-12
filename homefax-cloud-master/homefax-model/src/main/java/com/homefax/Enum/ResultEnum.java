package com.homefax.Enum;

/**
 * @Description: 统一返回结果包装
 * @Copyright (c) by HomeFax.
 * @All right reserved.
 * @Create Date: 2019/2/22 10:08
 * @Create Author: nevermore
 * @File Name: ResultEnum
 * @Last version: 1.0.0
 */
public enum ResultEnum {

    success("0000", "处理成功"),
    login_error("0001","登录有误"),
    exception("9999", "系统繁忙，请稍后重试")
    ;

    private String status;

    private String msg;

    ResultEnum(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static ResultEnum getEnumKey(String key){
        for (ResultEnum e : ResultEnum.values()){
            if (e.getStatus().equals(key)){
                return e;
            }
        }
        return null;
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
}
