package com.example.mvp.mvp.V3.presenter;

import com.example.mvp.mvp.V3.MainContract;
import com.example.mvp.mvp.V3.baseMVP.BasePresenter;
import com.example.mvp.mvp.V3.baseMVP.IBaseView;

public class TengPresenter   extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter{


    @Override
    public void attach(IBaseView view) {
        super.attach(view);

    }

    @Override
    public void handlerData() {

    }
}
