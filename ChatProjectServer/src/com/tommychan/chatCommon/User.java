package com.tommychan.chatCommon;

import java.io.Serializable;

/**
 * @author TommyChan
 * @version 1.0
 * description 表示一个用户信息
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String pwd;

    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
