package com.example.mvp.mvp.V2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.mvp.mvp.V2.baseMVP.IBasePresenter;
import com.example.mvp.mvp.V2.baseMVP.IBaseView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;

    protected abstract void initLayout(@Nullable Bundle saveInstanceState);

    protected abstract void initViews();

    protected abstract void initData();

    protected abstract P setPresenter();

    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout(savedInstanceState);
        mPresenter = setPresenter();
        mPresenter.attach(this);
        initViews();
        initData();
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑 避免内存泄露
        mPresenter.detach();
        mPresenter = null;
    }
}
