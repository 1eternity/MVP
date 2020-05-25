package com.example.mvp.mvp.V1.presenter;

import com.example.mvp.mvp.V1.MainContract;
import com.example.mvp.mvp.V1.model.DataModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainPresenter implements MainContract.IMainPresenter {

    private MainContract.IMainModel iMainModel;
    private MainContract.IMainView iMainView;

    public MainPresenter(MainContract.IMainView view) {
        this.iMainView = view;
        iMainModel = new DataModel();
    }

    @Override
    public void handlerData() {
        if (iMainView != null) {
            iMainView.showDialog();
        }
        iMainModel.requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (iMainView != null) {
                    iMainView.success(response.body().string());
                }
            }
        });
    }
}
