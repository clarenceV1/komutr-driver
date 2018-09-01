package com.komutr.driver.dagger.component;


import android.content.Context;

import com.cai.framework.dagger.module.FrameWorkModule;
import com.cai.framework.dataStore.ISharePreference;
import com.cai.framework.http.INet;
import com.cai.framework.imageload.ILoadImage;
import com.komutr.driver.dagger.module.CommonModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {CommonModule.class, FrameWorkModule.class})
public interface CommonComponent {

    Context provideContext();

    ILoadImage provideLoadImage();

    INet provideRequestNet();

    ISharePreference provideSharePreference();

    Retrofit provideRequestRetrofit();
}

