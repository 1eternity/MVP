package com.example.mvp.mvp.V1;

//契约类   可以很直观的看到M、V、P三层的接口

import okhttp3.Callback;

public interface MainContract {
    interface IMainModel {
        void requestBaidu(Callback callback);
    }

    interface IMainView {
        void showDialog();

        void success(String connect);
    }

    interface IMainPresenter {
        void handlerData();
    }
}
