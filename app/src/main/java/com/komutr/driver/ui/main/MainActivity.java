package com.komutr.driver.ui.main;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.example.clarence.utillibrary.ToastUtils;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.MainBinding;
import com.komutr.driver.R;
import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_MAIN, name = "首页")
public class MainActivity extends AppBaseActivity<MainBinding> implements MainView {
    @Inject
    MainPresenter presenter;

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
        setBarTitle("wo");
        mViewBinding.tvTitle222.setText(presenter.getTest2());
        mViewBinding.tvTitle222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.goLogin();
//                RouterManager.goWeb("http://www.baidu.com","百度是我孙子",null);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.main;
    }

    @Override
    public void tast(String msg) {
        ToastUtils.showShort(msg);
    }
}
