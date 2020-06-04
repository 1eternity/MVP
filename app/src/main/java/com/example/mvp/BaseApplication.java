package com.example.mvp;

import android.app.Application;
import android.util.Log;


import com.example.mvp.Dragger.DaggerMainComponent;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BaseApplication extends Application {

    @Inject
    OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMainComponent.create().inject(this);
        /**
         以下为OkHttp使用，与Dagger2无关
         */
        Request request = new Request.Builder().url("https://www.baidu.com/s?wd=世界上最帅的人").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("result", "查无此人");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.e("result", response.body().string());
            }
        });

    }
}
