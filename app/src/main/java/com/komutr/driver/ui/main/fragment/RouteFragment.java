package com.komutr.driver.ui.main.fragment;

import android.view.View;

import com.cai.framework.base.GodBasePresenterFragment;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.databinding.RouteBinding;

import java.util.List;

import javax.inject.Inject;

public class RouteFragment extends GodBasePresenterFragment<RouteBinding> implements RouteView {

    @Inject
    RoutePresenter presenter;

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
        return R.layout.route;
    }

    @Override
    public void initView(View view) {


    }
}
