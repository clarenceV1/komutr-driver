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
//        HeaderUtils.getInstance(this).topBarForCenter(getString(R.string.login));
////
//       mViewBinding.btnCommit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String code = mViewBinding.editCode.getText().toString();
//                String phone = mViewBinding.editPhone.getText().toString();
//
//                if (phoneCode != null) {
//                    presenter.registeredOrLogin(code, phone, phoneCode.getVer_token_key());
//                }
//
//            }
//        });
//        mViewBinding.btnGetCode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String phone = mViewBinding.editPhone.getText().toString();
//                presenter.verificationCode(phone, 1);
//            }
//        });
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

    /*@Override
    public void tosat(String msg) {
        ToastUtils.showShort(msg);
    }*/
}
