package com.komutr.client.dagger.component;


import com.cai.framework.dagger.ActivityScope;
import com.komutr.client.base.App;
import com.komutr.client.dagger.module.CommonModule;
import com.komutr.client.ui.login.LoginActivity;
import com.komutr.client.ui.main.MainActivity;
import com.komutr.client.ui.message.MessageActivity;
import com.komutr.client.ui.message.MessageDetailActivity;
import com.komutr.client.ui.wallet.WalletActivity;
import com.komutr.client.ui.web.WebActivity;

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
}
