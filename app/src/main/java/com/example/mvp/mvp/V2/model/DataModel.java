package com.example.mvp.mvp.V2.model;

import com.example.mvp.mvp.V2.MainContract;
import com.example.mvp.mvp.V2.baseMVP.BaseModel;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class DataModel extends BaseModel implements MainContract.IMainModel {
    @Override
    public void requestBaidu(Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
