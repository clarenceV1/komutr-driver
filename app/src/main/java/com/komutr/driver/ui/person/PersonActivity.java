package com.komutr.driver.ui.person;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.PersonBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.PERSON, name = "我的-个人信息")
public class PersonActivity extends AppBaseActivity<PersonBinding> implements PersonView {
    @Inject
    PersonPresenter presenter;

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
        setBarTitle(getString(R.string.person_title));
        mViewBinding.rLNickname.setOnClickListener(v ->
                RouterManager.goNickname()
        );
    }

    @Override
    public int getLayoutId() {
        return R.layout.person;
    }
}
