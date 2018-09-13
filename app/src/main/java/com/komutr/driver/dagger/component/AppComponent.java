package com.komutr.driver.dagger.component;


import com.cai.framework.dagger.ActivityScope;
import com.komutr.driver.base.App;
import com.komutr.driver.dagger.module.CommonModule;
import com.komutr.driver.service.GeTuiIntentService;
import com.komutr.driver.ui.aboutUs.AboutUsActivity;
import com.komutr.driver.ui.code.QRCodeActivity;
import com.komutr.driver.ui.email.BindEmailActivity;
import com.komutr.driver.ui.faq.FAQActivity;
import com.komutr.driver.ui.feedback.FeedbackActivity;
import com.komutr.driver.ui.helpCenter.HelpCenterActivity;
import com.komutr.driver.ui.income.IncomeRecordActivity;
import com.komutr.driver.ui.login.LoginActivity;
import com.komutr.driver.ui.main.MainActivity;
import com.komutr.driver.ui.main.fragment.MineFragment;
import com.komutr.driver.ui.main.fragment.RouteFragment;
import com.komutr.driver.ui.main.fragment.ScheduleFragment;
import com.komutr.driver.ui.message.MessageActivity;
import com.komutr.driver.ui.message.details.MessageDetailsActivity;
import com.komutr.driver.ui.nickname.NicknameActivity;
import com.komutr.driver.ui.password.ResetPasswordActivity;
import com.komutr.driver.ui.person.PersonActivity;
import com.komutr.driver.ui.phoneNumber.BindPhoneActivity;
import com.komutr.driver.ui.phoneNumber.ReplacePhoneActivity;
import com.komutr.driver.ui.register.RegisterActivity;
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
    void inject(BindEmailActivity fragment);
    void inject(ResetPasswordActivity fragment);
    void inject(RegisterActivity fragment);
    void inject(VerifiedActivity fragment);
    void inject(NicknameActivity fragment);
    void inject(IncomeRecordActivity fragment);
    void inject(PersonActivity fragment);
    void inject(QRCodeActivity fragment);
    void inject(WalletActivity fragment);
    void inject(ScheduleFragment fragment);
    void inject(RouteFragment fragment);
    void inject(MineFragment fragment);
    void inject(MainActivity activity);
    void inject(WebActivity activity);
    void inject(LoginActivity activity);
    void inject(MessageActivity activity);
    void inject(FAQActivity activity);
    void inject(FeedbackActivity activity);
    void inject(ReplacePhoneActivity activity);
    void inject(AboutUsActivity activity);
    void inject(HelpCenterActivity activity);
    void inject(GeTuiIntentService service);
    void inject(BindPhoneActivity activity);
    void inject(MessageDetailsActivity activity);

}
