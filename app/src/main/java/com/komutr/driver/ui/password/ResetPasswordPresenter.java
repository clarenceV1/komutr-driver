package com.komutr.driver.ui.password;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.cai.framework.logger.Logger;
import com.komutr.driver.base.AppBasePresenter;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.Constant;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ResetPasswordPresenter extends AppBasePresenter<ResetPasswordView> {

    @Inject
    public ResetPasswordPresenter() {

    }

    @Override
    public void onAttached() {
    }

    /**
     * 获取验证码
     *
     * @param phone type  1 注册 2 找回密码 3 重置密码
     */
    public void verificationCode(final String phone) {
        Map<String, Object> query = new HashMap<>();
        query.put("m", "customer.verification");
        query.put("auth_key", Constant.AUTH_KEY);
        query.put("phone", phone);
        query.put("type", "2");
        Disposable disposable = requestStore.get().commonRequest(query)
                .observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new Consumer<RespondDO>() {
                    @Override
                    public void accept(RespondDO respondDO) {
                        if (respondDO.isStatus() && !TextUtils.isEmpty(respondDO.getData())) {
                            PhoneCode phoneCode = JSON.parseObject(respondDO.getData(), PhoneCode.class);
                            respondDO.setObject(phoneCode);
                        }
                    }
                })
                .subscribe(respondDO -> {
                    Logger.d(respondDO.toString());
                    if (respondDO.isStatus()) { //成功
                        mView.verificationCodeCallback(respondDO);
                    } else {//失败
                        mView.verificationCodeCallback(respondDO);
                    }
                }, throwable -> {
                    Logger.e(throwable.getMessage());
                    RespondDO respondDO = new RespondDO();
                    mView.verificationCodeCallback(respondDO);
                });
        mCompositeSubscription.add(disposable);
    }
}
