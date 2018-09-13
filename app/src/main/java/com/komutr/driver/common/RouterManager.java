package com.komutr.driver.common;

import com.alibaba.android.arouter.launcher.ARouter;

public class RouterManager {
    public static final String ROUTER_HOME = "/komutr/";
    public static final String ROUTER_WEB = ROUTER_HOME + "WebActivity";
    public static final String ROUTER_MAIN = ROUTER_HOME + "MainActivity";
    public static final String ROUTER_LOGIN = ROUTER_HOME + "LoginActivity";
    public static final String ROUTER_MESSAGE = ROUTER_HOME + "MessageActivity";
    public static final String ROUTER_FAQ = ROUTER_HOME + "FAQActivity";
    public static final String ROUTER_FEEDBACK = ROUTER_HOME + "FeedbackActivity";
    public static final String ROUTER_REGION = ROUTER_HOME + "RegionActivity";
    public static final String ROUTER_WALLET = ROUTER_HOME + "WalletActivity";
    public static final String ROUTER_NICKNAME = ROUTER_HOME + "NicknameActivity";
    public static final String ROUTER_PERSON_INFO = ROUTER_HOME + "PersonInfoActivity";
    public static final String ROUTER_REPLACE_PHONE = ROUTER_HOME + "ReplacePhoneActivity";
    public static final String ROUTER_BIND_PHONE = ROUTER_HOME + "BindPhoneActivity";
    public static final String ROUTER_ABOUT_US = ROUTER_HOME + "AboutUsActivity";
    public static final String ROUTER_HELP_CENTER = ROUTER_HOME + "HelpCenterActivity";
    public static final String ROUTER_PHONE_NUMBER = ROUTER_HOME + "PhoneNumberActivity";
    public static final String ROUTER_BIND_EMAIL = ROUTER_HOME + "EmailActivity";
    public static final String ROUTER_BILL_DETAIL = ROUTER_HOME + "BillDetailActivity";
    public static final String PERSON = ROUTER_HOME + "PersonActivity";
    public static final String ROUTER_VERIFIED = ROUTER_HOME + "VerifiedActivity";
    public static final String ROUTER_QRCODE = ROUTER_HOME + "QRCodeActivity";
    public static final String ROUTER_INCOME_RECORD = ROUTER_HOME + "IncomeRecordActivity";
    public static final String ROUTER_REGISTER = ROUTER_HOME + "RegisterActivity";
    public static final String ROUTER_RESET_PASSWORD = ROUTER_HOME+"ResetPasswordActivity";

    public static void goIncomeRecord() {
        ARouter.getInstance().build(RouterManager.ROUTER_INCOME_RECORD).navigation();
    }
    public static void goResetPassword() {
        ARouter.getInstance().build(ROUTER_RESET_PASSWORD).navigation();
    }

    public static void goVerified() {
        ARouter.getInstance().build(ROUTER_VERIFIED).navigation();
    }

    public static void goPerson() {
        ARouter.getInstance().build(PERSON).navigation();
    }

    public static void goBillDetail(String billId) {
        ARouter.getInstance().build(RouterManager.ROUTER_BILL_DETAIL)
                .withString("BillId", billId)
                .navigation();
    }
    public static void goBindEmail() {
        ARouter.getInstance().build(RouterManager.ROUTER_BIND_EMAIL).navigation();
    }
    public static void goRegister() {
        ARouter.getInstance().build(RouterManager.ROUTER_REGISTER).navigation();
    }

    public static void goWeb(String url, String title, String paramMap) {
        ARouter.getInstance().build(ROUTER_WEB)
                .withString("url", url)
                .withString("title", title)
                .withString("paramMap", paramMap).navigation();
    }

    public static void goFAQ(int contentType) {
        ARouter.getInstance().build(ROUTER_FAQ)
                .withInt("contentType", contentType).navigation();
    }

    public static void goHelpCenter() {
        ARouter.getInstance().build(RouterManager.ROUTER_HELP_CENTER).navigation();
    }

    public static void goWallet() {
        ARouter.getInstance().build(RouterManager.ROUTER_WALLET).navigation();
    }

    public static void goAboutUs() {
        ARouter.getInstance().build(RouterManager.ROUTER_ABOUT_US).navigation();
    }

    public static void goQRCode() {
        ARouter.getInstance().build(RouterManager.ROUTER_QRCODE).navigation();
    }

    public static void goBindPhone() {
        ARouter.getInstance().build(ROUTER_BIND_PHONE).navigation();
    }

    public static void goPhoneNumber() {
        ARouter.getInstance().build(ROUTER_PHONE_NUMBER).navigation();

    }

    public static void goReplacePhone() {
        ARouter.getInstance().build(ROUTER_REPLACE_PHONE).navigation();
    }

    public static void goLogin() {
        ARouter.getInstance().build(ROUTER_LOGIN).navigation();
    }

    public static void goNickname() {
        ARouter.getInstance().build(ROUTER_NICKNAME).navigation();
    }

    public static void goPersonInfo() {
        ARouter.getInstance().build(ROUTER_PERSON_INFO).navigation();
    }

    public static void goFeedback() {
        ARouter.getInstance().build(ROUTER_FEEDBACK).navigation();
    }


    public static void goMessage() {
        ARouter.getInstance().build(ROUTER_MESSAGE).navigation();
    }

    public static void goRegion() {
        ARouter.getInstance().build(ROUTER_REGION).navigation();
    }


    public static final String CONFIRM_PAYMENT = ROUTER_HOME + "ConfirmPaymentActivity";


    public static final String MESSAGE_DETAILS = ROUTER_HOME + "MessageDetailsActivity";

    /**
     * 消息详情
     *
     * @param msgContent 消息内容
     */
    public static void goMessageDetails(String msgContent) {
        ARouter.getInstance().build(MESSAGE_DETAILS)
                .withString("msgContent", msgContent)
                .navigation();
    }


    public static void goMain() {
        ARouter.getInstance().build(ROUTER_MAIN).navigation();
    }

}
