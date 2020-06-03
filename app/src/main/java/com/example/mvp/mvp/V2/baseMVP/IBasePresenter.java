package com.example.mvp.mvp.V2.baseMVP;

public interface IBasePresenter<V extends IBaseView> {

    void attach(V view);

    void detach();
}
