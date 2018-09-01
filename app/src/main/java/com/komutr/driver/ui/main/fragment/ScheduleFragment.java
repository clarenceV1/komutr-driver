package com.komutr.driver.ui.main.fragment;

import android.view.View;

import com.cai.framework.base.GodBasePresenterFragment;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.databinding.ScheduleBinding;

import java.util.List;

import javax.inject.Inject;

public class ScheduleFragment extends GodBasePresenterFragment<ScheduleBinding> implements ScheduleView {

    @Inject
    SchedulePresenter presenter;

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
        return R.layout.schedule;
    }

    @Override
    public void initView(View view) {


    }
}
