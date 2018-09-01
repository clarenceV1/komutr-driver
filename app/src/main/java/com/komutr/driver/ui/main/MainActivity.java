package com.komutr.driver.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cai.framework.base.GodBasePresenter;
import com.example.clarence.utillibrary.ToastUtils;
import com.komutr.driver.R;
import com.komutr.driver.base.App;
import com.komutr.driver.base.AppBaseActivity;
import com.komutr.driver.common.RouterManager;
import com.komutr.driver.databinding.MainBinding;
import com.komutr.driver.ui.main.fragment.MineFragment;
import com.komutr.driver.ui.main.fragment.RouteFragment;
import com.komutr.driver.ui.main.fragment.ScheduleFragment;

import java.util.List;

import javax.inject.Inject;

@Route(path = RouterManager.ROUTER_MAIN, name = "首页")
public class MainActivity extends AppBaseActivity<MainBinding> implements MainView {
    @Inject
    MainPresenter presenter;

    public final String FRAGMENT_TAG = "main_fragment_";
    TabManager tabManager;
    int oldPosition = 0;
    private FragmentManager mFragmentManager;

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
        mFragmentManager = getSupportFragmentManager();
        tabManager = new TabManager(mViewBinding, new ITabClickListener() {
            @Override
            public void onClick(View v, int position) {
                switchFragment(position);
            }
        });
    }

    public void switchFragment(int currentPosition) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment oldFragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG + oldPosition);
        if (oldFragment != null) {
            transaction.hide(oldFragment);
        }
        Fragment currentFragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG + currentPosition);
        if (currentFragment != null) {
            transaction.show(currentFragment);
        } else {
            currentFragment = creatFragment(currentPosition);
            if (currentFragment != null) {
                transaction.add(R.id.mainContainer, currentFragment, FRAGMENT_TAG + currentPosition);
            }
        }
        transaction.commitAllowingStateLoss();
    }

    public Fragment creatFragment(int position) {
        switch (position) {
            case 0:
                return Fragment.instantiate(this, ScheduleFragment.class.getName());
            case 1:
                return Fragment.instantiate(this, RouteFragment.class.getName());
            case 2:
                return Fragment.instantiate(this, MineFragment.class.getName());
        }
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.main;
    }

    @Override
    public void tast(String msg) {
        ToastUtils.showShort(msg);
    }
}
