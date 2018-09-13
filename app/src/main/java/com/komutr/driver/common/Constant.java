package com.komutr.driver.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.komutr.driver.base.App;


public class Constant {
    public static boolean IS_DEBUG = true;
    public static final String OFFICIAL_BASE_URL = "http://car.xinjuhao.wang/";
    public static final String TEST_BASE_URL = "http://car.xinjuhao.wang/";
    private static final String IS_TEST_ENV = "is_test_env";//是否是测试环境

    public static final String AUTH_KEY = "d511D54i5Odb6WT";
   //tel 211111101 测试账号

//    AppID： BIrNhLcF4w7VRbWDVuQnH
//    AppSecret： V4xE6Fwqa187Y2V137sFt8
//    AppKey： s69oFojEHh6osFXMXmsbW1
//    MasterSecret： mIluqIfoOV9z3bs8SaY4q8
    /**
     * 设置是否是测试环境
     *
     * @param isTest
     */
    public static void saveTestEnv(boolean isTest) {
        SharedPreferences preferences = App.getAppContext().getSharedPreferences("default", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(IS_TEST_ENV, isTest).commit();
    }

    /**
     * 设置是否是测试环境
     *
     * @return
     */
    public static boolean isTestEnv() {
        SharedPreferences preferences = App.getAppContext().getSharedPreferences("default", Context.MODE_PRIVATE);
        return preferences.getBoolean(IS_TEST_ENV, false);
    }


    public interface RrequestFlag{


        int FLAG_1 = 1;

        int FLAG_2 = 2;

        int FLAG_3 = 3;

        int FLAG_4 = 4;

        int FLAG_5 = 5;

        int FLAG_6 = 6;

    }



    /**
     * activity请求和响应码
     */
    public static final class ActivityReqAndRes {
        /**
         * 打开相机
         */
        public static final int CHOOSE_OPEN_CAMERA = 1;
        /**
         * 选择相册图片
         */
        public static final int CHOOSE_SELECT_ALBUM = 2;

        /**
         * 裁剪头像
         */
        public static final int START_CUT_AVATAR = 3;

    }

    /**
     * 传递值的名称
     */
    public static final class SharedPrefer {
        /**
         * sp存在本地的名称
         */
        public static final String SHARE_MENU = "clientSp";


        /**
         * 手机号
         */
        public static final String TEL_NUMBER = "telNum";
    }



}
