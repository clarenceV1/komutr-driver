package com.komutr.driver.ui.message.details;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.MessageDetails;
import com.komutr.driver.been.RespondDO;

public interface MessageDetailsView extends GodBaseView {


    void callback(RespondDO<MessageDetails> respondDO);
}
