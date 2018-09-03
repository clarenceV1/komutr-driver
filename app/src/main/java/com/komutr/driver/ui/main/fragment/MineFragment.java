package com.komutr.driver.ui.main.fragment;

import android.view.View;

import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseFragment;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.MineBinding;

import java.util.List;

import javax.inject.Inject;

public class MineFragment extends AppBaseFragment<MineBinding> implements MineView {

    @Inject
    MinePresenter presenter;

    @Override
    public void addPresenters(List observerList) {
        observerList.add(presenter);
    }

    @Override
    public void initDagger() {
        App.getAppComponent().inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.mine;
    }

    @Override
    public void initView(View view) {
        initListener();
    }

    private void initListener() {
        mViewBinding.rlPerson.setOnClickListener(v -> RouterManager.goPerson());
        mViewBinding.rlWalllet.setOnClickListener(v -> RouterManager.goWallet());
        mViewBinding.rlVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RouterManager.goRegister();
                RouterManager.goLogin();
            }
        });
        mViewBinding.rlSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mViewBinding.rlVerified.setOnClickListener(v ->
                RouterManager.goVerified()
        );

        mViewBinding.rlSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mViewBinding.rlService.setOnClickListener(v ->
                presenter.callPhone(MineFragment.this, "13779926287")
        );
    }
}
