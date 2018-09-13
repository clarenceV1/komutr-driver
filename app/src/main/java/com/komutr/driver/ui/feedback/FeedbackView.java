package com.komutr.driver.ui.feedback;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.RespondDO;

public interface FeedbackView extends GodBaseView {


    void callback(RespondDO respondDO);
}
