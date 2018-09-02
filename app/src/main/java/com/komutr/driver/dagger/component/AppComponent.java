package com.komutr.driver.dagger.component;


import com.cai.framework.dagger.ActivityScope;
import com.komutr.driver.base.App;
import com.komutr.driver.dagger.module.CommonModule;
import com.komutr.driver.ui.login.LoginActivity;
import com.komutr.driver.ui.main.MainActivity;
import com.komutr.driver.ui.main.fragment.MineFragment;
import com.komutr.driver.ui.main.fragment.RouteFragment;
import com.komutr.driver.ui.main.fragment.ScheduleFragment;
import com.komutr.driver.ui.message.MessageActivity;
import com.komutr.driver.ui.message.MessageDetailActivity;
import com.komutr.driver.ui.verified.VerifiedActivity;
import com.komutr.driver.ui.wallet.WalletActivity;
import com.komutr.driver.ui.web.WebActivity;

import dagger.Component;

/**
 * Created by clarence on 2018/3/26
 */
@ActivityScope
@Component(dependencies = CommonComponent.class, modules = CommonModule.class)
public interface AppComponent {

    void inject(App app);
    void inject(MainActivity activity);
    void inject(WebActivity activity);
    void inject(LoginActivity activity);
    void inject(MessageActivity activity);
    void inject(MessageDetailActivity activity);
    void inject(WalletActivity activity);
    void inject(VerifiedActivity activity);

    void inject(ScheduleFragment fragment);
    void inject(RouteFragment fragment);
    void inject(MineFragment fragment);


}
