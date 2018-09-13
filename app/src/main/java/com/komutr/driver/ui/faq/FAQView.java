package com.komutr.driver.ui.faq;

import com.cai.framework.base.GodBaseView;
import com.komutr.driver.been.Faq;
import com.komutr.driver.been.RespondDO;

import java.util.List;

public interface FAQView extends GodBaseView {


    void callback(RespondDO<List<Faq>> respondDO);
}
