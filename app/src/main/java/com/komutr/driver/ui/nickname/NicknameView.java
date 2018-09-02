package com.komutr.driver.ui.nickname;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.RespondDO;

public interface NicknameView extends GodBaseView {


    void updateMyData(RespondDO respondDO);

    void checkUsername(RespondDO respondDO);
}
