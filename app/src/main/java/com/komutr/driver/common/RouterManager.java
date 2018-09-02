package com.komutr.driver.common;

import com.alibaba.android.arouter.launcher.ARouter;
import com.komutr.driver.ui.register.RegisterActivity;

public class RouterManager {
    public static final String ROUTER_HOME = "/komutr/";
    public static final String ROUTER_WEB = ROUTER_HOME + "WebActivity";
    public static final String ROUTER_MAIN = ROUTER_HOME + "MainActivity";
    public static final String ROUTER_LOGIN = ROUTER_HOME + "LoginActivity";
    public static final String ROUTER_MESSAGE = ROUTER_HOME + "MessageActivity";
    public static final String ROUTER_MESSAGE_DETAIL = ROUTER_HOME + "MessageDetailActivity";
    public static final String PERSON = ROUTER_HOME + "PersonActivity";
    public static final String ROUTER_VERIFIED = ROUTER_HOME + "VerifiedActivity";
    public static final String ROUTER_WALLET = ROUTER_HOME + "WalletActivity";
    public static final String ROUTER_NICKNAME = ROUTER_HOME + "NicknameActivity";
    public static final String ROUTER_QRCODE = ROUTER_HOME + "QRCodeActivity";
    public static final String ROUTER_INCOME_RECORD = ROUTER_HOME + "IncomeRecordActivity";
    public static final String ROUTER_REGISTER = ROUTER_HOME + "RegisterActivity";


    public static void goWeb(String url, String title, String paramMap) {
        ARouter.getInstance().build(RouterManager.ROUTER_WEB)
                .withString("url", url)
                .withString("title", title)
                .withString("paramMap", paramMap).navigation();
    }

    public static void goRegister() {
        ARouter.getInstance().build(RouterManager.ROUTER_REGISTER).navigation();
    }

    public static void goLogin() {
        ARouter.getInstance().build(RouterManager.ROUTER_LOGIN).navigation();
    }

    public static void goNickname() {
        ARouter.getInstance().build(RouterManager.ROUTER_NICKNAME).navigation();
    }

    public static void goVerified() {
        ARouter.getInstance().build(RouterManager.ROUTER_VERIFIED).navigation();
    }

    public static void goPerson() {
        ARouter.getInstance().build(RouterManager.PERSON).navigation();
    }

    public static void goWallet() {
        ARouter.getInstance().build(RouterManager.ROUTER_WALLET).navigation();
    }

    public static void goQRCode() {
        ARouter.getInstance().build(RouterManager.ROUTER_QRCODE).navigation();
    }

    public static void goIncomeRecord() {
        ARouter.getInstance().build(RouterManager.ROUTER_INCOME_RECORD).navigation();
    }
}
