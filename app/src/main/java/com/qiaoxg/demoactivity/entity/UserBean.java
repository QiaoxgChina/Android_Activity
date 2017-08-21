package com.qiaoxg.demoactivity.entity;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/17.
 */

public class UserBean implements Serializable {
    String userName;
    String age;

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
