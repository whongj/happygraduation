package com.happy.graduation.pojo;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/**
 * 学生表——只有用户名密码就好了。其他的放到conn里吧
 * Created by wanghongjie on 2017/5/28.
 */

public class Student implements Serializable {

    String sno;
    String password;


    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
