package com.komutr.driver.base;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cai.framework.base.GodBaseApplication;
import com.komutr.driver.BuildConfig;
import com.komutr.driver.been.MyObjectBox;
import com.komutr.driver.common.Constant;
import com.komutr.driver.dagger.component.AppComponent;
import com.komutr.driver.dagger.component.DaggerAppComponent;
import com.komutr.driver.dagger.component.DaggerCommonComponent;
import com.tencent.bugly.crashreport.CrashReport;

import javax.inject.Inject;

import io.objectbox.BoxStore;

/**
 * Created by clarence on 2018/1/11.
 */

public class App extends GodBaseApplication {
    public static AppComponent appComponent;
    public static BoxStore boxStore;

    @Inject
    AppPresenter appPresenter;


    public void onCreate() {
        super.onCreate();
        initRouter();
        initCrashReport();
        initComponent();
        initSql();
    }

    private void initSql() {
        boxStore = MyObjectBox.builder().androidContext(this).build();
    }

    @Override
    public void initWebProtocol() {

    }


    /**
     * 错误报告
     */
    private void initCrashReport() {
        CrashReport.initCrashReport(getApplicationContext());
    }

    /**
     * 初始化各模块dagger组件
     */
    private void initComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().commonComponent(DaggerCommonComponent.builder().build()).build();
            appComponent.inject(this);
        }
    }


    @Override
    public String getBaseUrl() {
        if (BuildConfig.DEBUG) {
            if (Constant.isTestEnv()) {
                return Constant.TEST_BASE_URL;
            }
        }
        return Constant.OFFICIAL_BASE_URL;
    }

    @Override
    public boolean isDebug() {
        return Constant.IS_DEBUG;
    }

    private void initRouter() {
        if (Constant.IS_DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }
}
