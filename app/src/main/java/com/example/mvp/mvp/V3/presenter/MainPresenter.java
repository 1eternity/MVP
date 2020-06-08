package com.example.mvp.mvp.V3.presenter;

import android.util.Log;

import com.example.mvp.mvp.V3.MainContract;
import com.example.mvp.mvp.V3.baseMVP.BasePresenter;
import com.example.mvp.mvp.V3.baseMVP.IBaseView;
import com.example.mvp.mvp.V3.model.DataModel;

import java.io.IOException;

import javax.inject.Inject;

import dagger.Module;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MainPresenter extends BasePresenter<MainContract.IMainView,DataModel> implements MainContract.IMainPresenter {
    private static final String TAG = "MainPresenter";

//    private IBaseView view;
    @Inject
    public MainPresenter(){
        Log.i(TAG, "MainPresenter: ");
//        this.view=view;
    }
    @Override
    public void detech() {
        super.detech();
        //用来释放内存 关闭网络请求 关闭线程操作
    }

    @Override
    public void handlerData() {
//        if(getView()!=null){  //使用了动态代理后 可以减少繁琐的非空判断
            getView().showDialog();
//        }
        getModel().requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                if(getView()!=null) {
                    getView().success(response.body().string());
//                }
            }
        });
    }
}
