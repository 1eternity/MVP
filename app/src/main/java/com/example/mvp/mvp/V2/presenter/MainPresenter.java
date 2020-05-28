package com.example.mvp.mvp.V2.presenter;

import com.example.mvp.mvp.V2.MainContract;
import com.example.mvp.mvp.V2.baseMVP.BasePresenter;
import com.example.mvp.mvp.V2.baseMVP.IBaseView;
import com.example.mvp.mvp.V2.model.DataModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainPresenter extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter {

    private MainContract.IMainModel mModel;
    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        mModel = new DataModel();
    }

    @Override
    public void detech() {
        super.detech();
    }

    @Override
    public void handlerData() {
        if(mView!=null){
            mView.showDialog();
        }
        mModel.requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(mView!=null) {
                    mView.success(response.body().string());
                }

            }
        });
    }
}
