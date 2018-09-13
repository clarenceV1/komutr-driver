package com.komutr.driver.ui.email;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RespondDO;

public interface BindEmailView extends GodBaseView {


    void checkEmail(RespondDO<PhoneCode> respondDO);

    void bindEmailCallback(RespondDO respondDO);
}
