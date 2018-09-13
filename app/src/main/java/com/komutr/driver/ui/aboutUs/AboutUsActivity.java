package com.komutr.driver.ui.aboutUs;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.been.AboutUs;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.AboutBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_ABOUT_US, name = "我的-关于我们")
public class AboutUsActivity extends AppBaseActivity<AboutBinding> implements AboutUsView {
    @Inject
    AboutUsPresenter presenter;

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
        setBarTitle(getString(R.string.about_us_title));
        presenter.requestContent();
    }

    @Override
    public int getLayoutId() {
        return R.layout.about;
    }

    @Override
    public void callback(RespondDO<AboutUs> respondDO) {

    }
}
