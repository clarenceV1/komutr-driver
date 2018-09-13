package com.komutr.driver.ui.message.details;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cai.framework.base.GodBasePresenter;
import com.example.clarence.utillibrary.ToastUtils;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.been.MessageDetails;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.MessageDetailsBinding;


import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.MESSAGE_DETAILS, name = "消息-消息详情")
public class MessageDetailsActivity extends AppBaseActivity<MessageDetailsBinding> implements MessageDetailsView, View.OnClickListener {

    @Inject
    MessageDetailsPresenter presenter;

    @Autowired(name = "msgContent")
    String msgContent;



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
        ARouter.getInstance().inject(this);
        setBarTitle(getString(R.string.message_details));
        mViewBinding.tvMessageContent.setText(msgContent);
//        onShowLoadDialog(getString(R.string.loading), this);
//        presenter.requestMessageDetails(msgContent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.message_details;
    }

    @Override
    public void callback(RespondDO<MessageDetails> respondDO) {
//        hiddenDialog();
        if (respondDO.isStatus()) {
            MessageDetails data = respondDO.getObject();

        } else {
            ToastUtils.showShort(respondDO.getMsg());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dialog_reloading_text://刷新重新获取数据
//                onShowLoadDialog(getString(R.string.loading), this);
//                presenter.requestMessageDetails(msgId);
                break;
        }
    }
}
