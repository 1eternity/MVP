package com.example.mvp.mvp.V3.presenter;

import com.example.mvp.mvp.V3.MainContract;
import com.example.mvp.mvp.V3.baseMVP.BasePresenter;
import com.example.mvp.mvp.V3.baseMVP.IBaseView;
import com.example.mvp.mvp.V3.model.TengModel;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TengPresenter extends BasePresenter<MainContract.IMainView,TengModel> implements MainContract.IMainPresenter {


    @Inject
    public TengPresenter(){

    }
    @Override
    public void handlerData() {
        getView().showDialog();
        getModel().requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                getView().tendSuccess(response.body().string());
            }
        });
    }
}
