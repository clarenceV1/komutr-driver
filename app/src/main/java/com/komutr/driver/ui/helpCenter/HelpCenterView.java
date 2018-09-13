package com.komutr.driver.ui.helpCenter;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.HelpCenter;
import com.komutr.driver.been.RespondDO;

import java.util.List;

public interface HelpCenterView extends GodBaseView {


    void helpListCallback(RespondDO<List<HelpCenter>> respondDO);

    void detailCallback(RespondDO respondDO);
}
