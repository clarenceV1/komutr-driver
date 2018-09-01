package com.komutr.driver.base;

import com.cai.framework.base.GodBasePresenter;
import com.komutr.driver.common.AppDataCacheStore;
import com.komutr.driver.common.AppDataStore;
import com.komutr.driver.common.AppFileStore;
import com.komutr.driver.common.AppRequestStore;
import com.komutr.driver.dao.UserInfoDao;

import javax.inject.Inject;

import dagger.Lazy;

public abstract class AppBasePresenter<V> extends GodBasePresenter<V> {

    @Inject
    public Lazy<AppDataStore> dataStore;
    @Inject
    public Lazy<AppRequestStore> requestStore;
    @Inject
    public Lazy<AppFileStore> fileStore;
    @Inject
    public Lazy<AppDataCacheStore> cacheStore;
    @Inject
    public UserInfoDao userInfoDao;

}
