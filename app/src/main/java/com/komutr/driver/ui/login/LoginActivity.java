package com.komutr.driver.ui.login;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.LoginBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_LOGIN, name = "登录/注册")
public class LoginActivity extends AppBaseActivity<LoginBinding> implements LoginView {
    @Inject
    LoginPresenter presenter;

    PhoneCode phoneCode;

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

        mViewBinding.btnCommit.setOnClickListener(v -> {
            String password = mViewBinding.editPassword.getText().toString();
            String phone = mViewBinding.etPhone.getText().toString();
            presenter.login(phone,password);
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.login;
    }

    @Override
    public void verificationCodeCallback(RespondDO respondDO) {
        this.phoneCode = (PhoneCode) respondDO.getObject();
    }

    @Override
    public void registeredOrLoginCallBack(RespondDO respondDO) {

    }
}
