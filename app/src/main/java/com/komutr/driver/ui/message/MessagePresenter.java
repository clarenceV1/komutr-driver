package com.komutr.driver.ui.message;

import com.alibaba.fastjson.JSON;
import com.cai.framework.base.GodBaseApplication;
import com.cai.framework.logger.Logger;
import com.example.clarence.utillibrary.StringUtils;
import com.komutr.driver.R;
import com.komutr.driver.base.AppBasePresenter;
import com.komutr.driver.been.Message;
import com.komutr.driver.been.RespondDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MessagePresenter extends AppBasePresenter<MessageView> {


    @Inject
    public MessagePresenter() {

    }

    @Override
    public void onAttached() {

    }


    public void requestMessage(final int start, final int size) {
        String auth_key = userInfoDao.get().getAppAuth();
        Map<String, Object> query = new HashMap<>();
        query.put("m", "system.message");
        query.put("auth_key", auth_key);
        query.put("limit", start + "," + size);
        Disposable disposable = requestStore.get().commonRequest(query)
                .doOnSuccess(new Consumer<RespondDO>() {
                    @Override
                    public void accept(RespondDO respondDO) {
                        if (respondDO.isStatus() && !StringUtils.isEmpty(respondDO.getData())) {
                            List<Message> messageList = messageDao.get().addAll(JSON.parseArray(respondDO.getData(), Message.class),start,size);
                            respondDO.setObject(messageList);
                        }else {
                            List<Message> messageList = messageDao.get().getMessageList(start,size);
                            if(messageList != null && !messageList.isEmpty()){
                                respondDO.setObject(messageList);
                                respondDO.setStatus(true);
                            }
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RespondDO>() {
                    @Override
                    public void accept(RespondDO respondDO) {
                        Logger.d(respondDO.toString());
                        mView.callback(respondDO);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Logger.e(throwable.getMessage());
                        RespondDO respondDO = new RespondDO();
                        List<Message> messageList = messageDao.get().getMessageList(start,size);
                        if(messageList != null && !messageList.isEmpty()){
                            respondDO.setObject(messageList);
                            respondDO.setStatus(true);
                        }else {
                            respondDO.setMsg(GodBaseApplication.getAppContext().getString(R.string.request_failed));
                        }
                        mView.callback(respondDO);
                    }
                });
        mCompositeSubscription.add(disposable);
    }


    public void updateStatus(int id, int status) {

        messageDao.get().updateStatus(id, status);
    }
}
