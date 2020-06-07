package com.example.mvp.mvp.V3;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.mvp.mvp.V3.Dagger2.Component.ActivityComponent;
import com.example.mvp.mvp.V3.Dagger2.Component.DaggerActivityComponent;
import com.example.mvp.mvp.V3.Dagger2.module.ActivityModule;
import com.example.mvp.mvp.V3.baseMVP.IBasePresenter;
import com.example.mvp.mvp.V3.baseMVP.IBaseView;

import javax.inject.Inject;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.Module;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    @Inject
    protected P mPresenter;

    protected abstract void initLayout(@Nullable Bundle saveInstanceState);

    protected abstract void initViews();

    protected abstract void initData();

//    protected abstract P setPresenter();

    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout(savedInstanceState);
        initInJect();
//        mPresenter = setPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initViews();
        initData();
    }

    protected abstract void initInJect();

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑 避免内存泄露
        if (mPresenter != null) {
            mPresenter.detech();
        }
        mPresenter = null;
    }
}
