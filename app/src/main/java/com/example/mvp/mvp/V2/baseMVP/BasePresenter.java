package com.example.mvp.mvp.V2.baseMVP;

public class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;

    @Override
    public void attach(IBaseView view) {
        mView = (V) view;
    }

    @Override
    public void detech() {
        mView = null;
    }
}
