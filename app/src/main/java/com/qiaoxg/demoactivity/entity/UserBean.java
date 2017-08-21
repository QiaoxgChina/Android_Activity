package com.qiaoxg.demoactivity.entity;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/17.
 */

public class UserBean implements Serializable {

    int header;
    String userName;
    String age;
    String phone;

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
