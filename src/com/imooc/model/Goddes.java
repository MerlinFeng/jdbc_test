package com.imooc.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/5.
 */
public class Goddes {
//    id int(11) NOT NULL AUTO_INCREMENT,
//    user_name varchar(255) NOT NULL,
//    sex varchar(255) DEFAULT NULL,
//    age int(11) DEFAULT NULL,
//    birthday date DEFAULT NULL,
//    email varchar(255) DEFAULT NULL,
//    mobile varchar(255) DEFAULT NULL,
//    create_user varchar(255) DEFAULT NULL,
//    create_date date DEFAULT NULL,
//    update_user varchar(255) DEFAULT NULL,
//    update_date date DEFAULT NULL,
//    isdel int(11) DEFAULT NULL,

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String user_name;
    private Integer sex=1;
    private Integer age;
    private String email;
    private String mobile;
    private String create_user="admin";
    private String update_user="admin";
    private Integer isdel=0;
    private Date birthday;
    private Date create_date;
    private Date update_date;

    @Override
    public String toString() {
        return "Goddes{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", create_user='" + create_user + '\'' +
                ", update_user='" + update_user + '\'' +
                ", isdel=" + isdel +
                ", birthday=" + birthday +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
}
