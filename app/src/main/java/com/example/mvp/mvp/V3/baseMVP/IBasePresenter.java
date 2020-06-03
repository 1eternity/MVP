package com.example.mvp.mvp.V3.baseMVP;

public interface IBasePresenter<V extends IBaseView> {

    void attach(V view);

    void detech();
}
