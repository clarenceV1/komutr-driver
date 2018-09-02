package com.komutr.driver.ui.verified;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.cai.framework.imageload.ILoadImage;
import com.cai.framework.imageload.ILoadImageParams;
import com.cai.framework.imageload.ImageForGlideParams;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.VerifiedBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_VERIFIED, name = "我的-实名认证")
public class VerifiedActivity extends AppBaseActivity<VerifiedBinding> implements VerifiedView {
    @Inject
    VerifiedPresenter presenter;
    @Inject
    ILoadImage iLoadImage;

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
        setBarTitle(getString(R.string.my_verified));
        ILoadImageParams imageParams = new ImageForGlideParams.Builder()
                .url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536463927&di=1fe7a492f833960e4eddd2e968bc8b32&imgtype=jpg&er=1&src=http%3A%2F%2Fww2.sinaimg.cn%2Fbmiddle%2F0062Tsskjw1ev5k66vo12j30c80gbt9w.jpg")
                .error(R.color.color_f1f1f4)
                .build();
        imageParams.setImageView(mViewBinding.imgVerified);
        iLoadImage.loadImage(this, imageParams);
    }

    @Override
    public int getLayoutId() {
        return R.layout.verified;
    }
}
