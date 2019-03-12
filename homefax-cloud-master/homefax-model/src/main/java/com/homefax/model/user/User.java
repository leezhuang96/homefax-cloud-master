package com.homefax.model.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


@ApiModel(value = "用户实体类",description = "这是用户对象")
public class User {

    @ApiModelProperty(hidden = true)
    private String uuid;

    @ApiModelProperty(value = "生日",example = "2018-01-01 11:11:11",required = true)
    private Date birthday;

    @ApiModelProperty(value = "性别，1：男，0：女",example = "1",required = true)
    private String gender;

    @ApiModelProperty(value = "姓名",example = "tom",required = true)
    private String name;

    @ApiModelProperty(value = "密码六位",example = "123456",required = true)
    private String password;

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}