package com.komutr.driver.ui.nickname;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.been.RespondDO;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.NicknameBinding;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_NICKNAME, name = "昵称")
public class NicknameActivity extends AppBaseActivity<NicknameBinding> implements NicknameView {
    @Inject
    NicknamePresenter presenter;
    TextView tvRight;

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
        setBarTitle(getString(R.string.nickname_title));
        if (titleBarView != null) {
            titleBarView.setRightText(getString(R.string.save));
            tvRight = titleBarView.getRightTextView();
            tvRight.setOnClickListener(v -> {
                        String nickName = mViewBinding.editNickname.getText().toString();
                        presenter.checkUsername(nickName);
                    }
            );
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.nickname;
    }

    @Override
    public void updateMyData(RespondDO respondDO) {

    }

    @Override
    public void checkUsername(RespondDO respondDO) {

    }
}
