package com.komutr.driver.ui.main.fragment;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import com.cai.framework.permission.RxPermissions;
import com.example.clarence.utillibrary.ToastUtils;
import com.komutr.driver.base.AppBasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class MinePresenter extends AppBasePresenter<MineView> {
    @Inject
    public MinePresenter() {
    }

    @Override
    public void onAttached() {

    }

    public void callPhone(Fragment fragment, String phoneNum) {
        RxPermissions permissions = new RxPermissions(fragment);
        Disposable disposable = permissions.request(Manifest.permission.CALL_PHONE).subscribe(granted -> {
            if (granted) {
                callPhone(phoneNum);
            } else {
                ToastUtils.showShort("one");
            }
        });
        mCompositeSubscription.add(disposable);
    }

    @SuppressLint("MissingPermission")
    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(data);
        context.startActivity(intent);
    }
}
