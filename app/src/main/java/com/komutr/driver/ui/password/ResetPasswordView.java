package com.komutr.driver.ui.password;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RespondDO;

public interface ResetPasswordView extends GodBaseView {

    void verificationCodeCallback(RespondDO<PhoneCode> respondDO);
}
