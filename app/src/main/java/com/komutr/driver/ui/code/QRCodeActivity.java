package com.komutr.driver.ui.code;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.QrcodeBinding;
import com.komutr.driver.ui.wallet.WalletView;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_QRCODE, name = "我的-二维码首款")
public class QRCodeActivity extends AppBaseActivity<QrcodeBinding> implements WalletView {
    @Inject
    QRCodePresenter presenter;

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
        setBarTitle(getString(R.string.qr_code_title));
    }

    @Override
    public int getLayoutId() {
        return R.layout.qrcode;
    }
}
