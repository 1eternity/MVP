package com.example.mvp;

import android.app.Application;


import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class BaseApplication extends Application {

    @Inject
    OkHttpClient okHttpClient;
    private static BaseApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
//        DaggerMainComponent.create().inject(this);
        /**
         以下为OkHttp使用，与Dagger2无关
         */
//        Request request = new Request.Builder().url("https://www.baidu.com/s?wd=世界上最帅的人").build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("result", "查无此人");
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                Log.e("result", response.body().string());
//            }
//        });

    }
//    public static AppComponent getAppComponent(){
//        return DaggerAppComponent.builder()
//                .appModule(new AppModule(instance))
//                .build();
//    }
}
