package com.komutr.driver.ui.message;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.Message;
import com.komutr.driver.been.RespondDO;

import java.util.List;

public interface MessageView extends GodBaseView {


    void callback(RespondDO<List<Message>> respondDO);
}
