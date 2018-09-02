package com.komutr.driver.ui.login;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.cai.framework.logger.Logger;
import com.komutr.driver.base.AppBasePresenter;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.been.User;
import com.komutr.driver.common.Constant;
import com.komutr.driver.dao.UserInfoDao;
import com.komutr.driver.event.LoginEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.Lazy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class LoginPresenter extends AppBasePresenter<LoginView> {

    @Inject
    Lazy<UserInfoDao> userInfoDao;

    @Inject
    public LoginPresenter() {

    }

    @Override
    public void onAttached() {
    }

    public void login(String phone, String password) {
        Map<String, String> query = new HashMap<>();
        query.put("m", "chauffeur.login");
        query.put("phone", phone);
        query.put("password", password);
        query.put("auth_key", Constant.APP_AUTH);
        Disposable disposable = requestStore.get().commonRequest(query).doOnSuccess(new Consumer<RespondDO>() {
            @Override
            public void accept(RespondDO respondDO) {
                Log.d("login", respondDO.toString());
                if (respondDO.isStatus() && !TextUtils.isEmpty(respondDO.getData())) {
                    User userInfo = JSON.parseObject(respondDO.getData(), User.class);
                    respondDO.setObject(userInfo);
                    if (userInfoDao != null) {
                        userInfoDao.get().saveAndDelete(userInfo);
                    }
                    EventBus.getDefault().post(new LoginEvent(1, userInfo));
                }
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(respondDO -> {
                    if (respondDO.isStatus()) { //成功
                        mView.registeredOrLoginCallBack(respondDO);
                    } else {//失败
                        mView.registeredOrLoginCallBack(respondDO);
                    }
                }, throwable ->
                    Logger.e(throwable.getMessage())
                );
        mCompositeSubscription.add(disposable);
    }
}
