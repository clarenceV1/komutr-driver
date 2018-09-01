package com.komutr.driver.ui.message;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.MessageDetailBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_MESSAGE_DETAIL, name = "消息详情")
public class MessageDetailActivity extends AppBaseActivity<MessageDetailBinding> implements MessageDetailView {

    @Inject
    MessageDetailPresenter presenter;

    @Override
    public void initDagger() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void addPresenters(List<GodBasePresenter> observerList) {
        observerList.add(presenter);
    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.message_detail;
    }
}
