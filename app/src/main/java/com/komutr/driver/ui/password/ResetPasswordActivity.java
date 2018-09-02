package com.komutr.driver.ui.password;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.ResetPasswordBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_RESET_PASSWORD, name = "忘记密码")
public class ResetPasswordActivity extends AppBaseActivity<ResetPasswordBinding> implements ResetPasswordView {
    @Inject
    ResetPasswordPresenter presenter;
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
        setBarTitle(getString(R.string.reset_password_title));
        mViewBinding.btnCode.setOnClickListener(v -> {
            String phone = mViewBinding.etPhone.getText().toString();
            presenter.verificationCode(phone);
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.reset_password;
    }

    @Override
    public void verificationCodeCallback(RespondDO<PhoneCode> respondDO) {
        this.phoneCode = respondDO.getObject();
    }
}
