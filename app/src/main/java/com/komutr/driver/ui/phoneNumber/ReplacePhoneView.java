package com.komutr.driver.ui.phoneNumber;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RespondDO;

public interface ReplacePhoneView extends GodBaseView {


    void verificationCodeCallback(RespondDO<PhoneCode> respondDO);

    void changePhoneNumberCallback(RespondDO respondDO);
}
