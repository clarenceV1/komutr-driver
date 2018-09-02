package com.komutr.driver.ui.income;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.IncomeRecordBinding;
import com.komutr.driver.ui.wallet.WalletPresenter;

import java.util.List;
import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_INCOME_RECORD, name = "我的-我的钱包-收款记录")
public class IncomeRecordActivity extends AppBaseActivity<IncomeRecordBinding> implements IncomeRecordView {
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
        setBarTitle(getString(R.string.income_record_title));
    }

    @Override
    public int getLayoutId() {
        return R.layout.income_record;
    }
}
