package com.example.mvp.mvp.V3;

//契约类   可以很直观的看到M、V、P三层的接口

import com.example.mvp.mvp.V3.baseMVP.IBasePresenter;
import com.example.mvp.mvp.V3.baseMVP.IBaseView;

import javax.inject.Inject;

import dagger.Module;
import okhttp3.Callback;

public interface MainContract {
    interface IMainModel {
        void requestBaidu(Callback callback);
    }

    interface IMainView extends IBaseView {
        void showDialog();

        void success(String connect);
    }

    interface IMainPresenter extends IBasePresenter {
        void handlerData();
    }
}
