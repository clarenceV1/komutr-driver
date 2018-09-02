package com.komutr.driver.ui.register;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.RespondDO;

public interface RegisterView extends GodBaseView {

    void verificationCodeCallback(RespondDO respondDO);

    void registeredOrLoginCallBack(RespondDO respondDO);

//    void showToastMsg(String msg);
}
