package com.komutr.driver.ui.aboutUs;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.AboutUs;
import com.komutr.driver.been.RespondDO;

public interface AboutUsView extends GodBaseView {


    void callback(RespondDO<AboutUs> respondDO);
}
