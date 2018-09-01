package com.komutr.driver.ui.login;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.RespondDO;

public interface LoginView extends GodBaseView {

    void verificationCodeCallback(RespondDO respondDO);

    void registeredOrLoginCallBack(RespondDO respondDO);

//    void showToastMsg(String msg);
}
