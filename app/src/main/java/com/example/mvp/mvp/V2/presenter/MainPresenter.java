package com.example.mvp.mvp.V2.presenter;

import com.example.mvp.mvp.V2.MainContract;
import com.example.mvp.mvp.V2.baseMVP.BasePresenter;
import com.example.mvp.mvp.V2.model.DataModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainPresenter extends BasePresenter<MainContract.IMainView, DataModel> implements MainContract.IMainPresenter {

    //    private MainContract.IMainModel mModel;
//    @Override
//    public void attach(IBaseView view) {
//        super.attach(view);
//        mModel = new DataModel();
//    }
    @Override
    public void detach() {
        super.detach();
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
