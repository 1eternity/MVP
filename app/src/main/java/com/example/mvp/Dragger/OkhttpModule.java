package com.example.mvp.Dragger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class OkhttpModule {

    @Provides
    @Singleton
    public OkHttpClient okhttpClientProvider() {
        return new OkHttpClient();
    }
}
