package com.komutr.driver.ui.register;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.RegisterBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_REGISTER, name = "注册")
public class RegisterActivity extends AppBaseActivity<RegisterBinding> implements RegisterView {
    @Inject
    RegisterPresenter presenter;

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
            String code = mViewBinding.etInputVerificAtionCode.getText().toString();
            String phone = mViewBinding.etPhone.getText().toString();
            String password = mViewBinding.editPassword.getText().toString();
            if (phoneCode != null) {
                presenter.registered(phone, password, code, phoneCode.getVer_token_key());
            }
        });
        mViewBinding.btnVerificationCode.setOnClickListener(v -> {
            String phone = mViewBinding.etPhone.getText().toString();
            presenter.verificationCode(phone);
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.register;
    }

    @Override
    public void verificationCodeCallback(RespondDO respondDO) {
        this.phoneCode = (PhoneCode) respondDO.getObject();
    }

    @Override
    public void registeredOrLoginCallBack(RespondDO respondDO) {

    }
}
