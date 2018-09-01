package com.komutr.driver.event;

import com.komutr.driver.been.User;

public class LoginEvent {
    public static final int STATE_LOGIN_SUCCESS = 1;
    public static final int STATE_LOGIN_OUT_SUCCESS = 2;

    private int stateType;
    private User userInfo;

    public LoginEvent(int stateType, User userInfo) {
        this.stateType = stateType;
        this.userInfo = userInfo;
    }
}
