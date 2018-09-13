package com.komutr.driver.ui.register;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.cai.framework.logger.Logger;
import com.komutr.driver.base.AppBasePresenter;
import com.komutr.driver.been.PhoneCode;
import com.komutr.driver.been.RegisterDO;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.Constant;
import com.komutr.driver.dao.UserInfoDao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.Lazy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RegisterPresenter extends AppBasePresenter<RegisterView> {

    @Inject
    Lazy<UserInfoDao> userInfoDao;

    @Inject
    public RegisterPresenter() {

    }

    @Override
    public void onAttached() {
    }

    public void registered( String phone,String password, String code, String verTokenKey) {
        Map<String, Object> query = new HashMap<>();
        query.put("m", "chauffeur.registered");
        query.put("auth_key", Constant.AUTH_KEY);
        query.put("phone", phone);
        query.put("ver_token_key", verTokenKey);
        query.put("code", code);
        query.put("password", password);
        Disposable disposable = requestStore.get().commonRequest(query).doOnSuccess((RespondDO respondDO) -> {
            if (respondDO.isStatus() && !TextUtils.isEmpty(respondDO.getData())) {
                Log.d("registered", respondDO.getData());
                RegisterDO registerDO = JSON.parseObject(respondDO.getData(), RegisterDO.class);
                respondDO.setObject(registerDO);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(respondDO -> {
                            Log.d("registered", respondDO.toString());
                    mView.registeredOrLoginCallBack(respondDO);
                        }, throwable ->
                                Logger.e(throwable.getMessage())
                );
        mCompositeSubscription.add(disposable);
    }

    /**
     * 获取验证码
     *
     * @param phone
     * type  1 注册 2 找回密码 3 重置密码
     */
    public void verificationCode(final String phone) {
        Map<String, Object> query = new HashMap<>();
        query.put("m", "customer.verification");
        query.put("auth_key", Constant.AUTH_KEY);
        query.put("phone", phone);
        query.put("type", "1");
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
