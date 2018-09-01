package com.komutr.driver.ui.wallet;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.WalletBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_WALLET, name = "我的-我的钱包")
public class WalletActivity extends AppBaseActivity<WalletBinding> implements WalletView {
    @Inject
    WalletPresenter presenter;

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
        return R.layout.wallet;
    }
}
