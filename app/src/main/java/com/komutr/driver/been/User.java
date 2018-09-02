package com.komutr.driver.been;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class User {
    private long id;
    @Id
    private long userId;
    private String user_type;
    private String phone;
    private String app_auth;
    private String check_status;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getApp_auth() {
        return app_auth;
    }

    public void setApp_auth(String app_auth) {
        this.app_auth = app_auth;
    }

    public String getCheck_status() {
        return check_status;
    }

    public void setCheck_status(String check_status) {
        this.check_status = check_status;
    }
}
