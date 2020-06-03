package com.example.mvp.mvp.V2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.mvp.mvp.V2.baseMVP.BasePresenter;
import com.example.mvp.mvp.V2.baseMVP.IBasePresenter;
import com.example.mvp.mvp.V2.baseMVP.IBaseView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;
    private List<BasePresenter> mInjectPresenters;

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
        if(mPresenter!=null) {
            mPresenter.attach(this);
        }
        mInjectPresenters = new ArrayList<>();

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter annotation = field.getAnnotation(InjectPresenter.class);
            if(annotation!=null){
                Class<? extends BasePresenter> type= (Class<? extends BasePresenter>)field.getType();
                try {
                    BasePresenter basePresenter = type.newInstance();
                    basePresenter.attach(this);
                    field.setAccessible(true);
                    field.set(this,basePresenter);
                    mInjectPresenters.add(basePresenter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

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
        if(mPresenter!=null) {
            mPresenter.detech();
            mPresenter = null;
        }
        for (BasePresenter mInjectPresenter : mInjectPresenters) {
            mInjectPresenter.detech();
        }
        mInjectPresenters.clear();
        mInjectPresenters=null;
    }

    public P getmPresenter() {
        return mPresenter;
    }
}
