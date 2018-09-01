package com.komutr.driver.base;

import com.komutr.driver.common.AppDataStore;
import com.komutr.driver.common.AppFileStore;
import com.komutr.driver.common.AppRequestStore;

import javax.inject.Inject;

import dagger.Lazy;

public class AppPresenter {
    @Inject
    public Lazy<AppDataStore> dataStore;
    @Inject
    public Lazy<AppRequestStore> requestStore;
    @Inject
    public Lazy<AppFileStore> fileStore;

    @Inject
    public AppPresenter() {

    }

}
