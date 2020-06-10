package com.example.mvp.mvp.V3.baseMVP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.mvp.V3.Dagger2.Component.ActivityComponent;
import com.example.mvp.mvp.V3.Dagger2.Component.DaggerActivityComponent;
import com.example.mvp.mvp.V3.Dagger2.module.ActivityModule;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Date:2020/6/8 0008
 * Time:16:58
 * author:liguoqiang
 */
public abstract class BaseFragment extends Fragment implements IBaseView {

    private List<BasePresenter> presenterList ;


    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract List<BasePresenter> setPresenter(List<BasePresenter> presenterList);

    protected abstract void initInject();

    protected abstract int setLayout();

    protected <T extends View> T $(@IdRes int viewId) {
        return this.getView().findViewById(viewId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);
        initInject();
        presenterList=new ArrayList<>();
        presenterList = setPresenter(presenterList);
        for (BasePresenter basePresenter : presenterList) {
            if (basePresenter != null) {
                basePresenter.attach(this);
            }
        }
        return view;
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(getActivity());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(savedInstanceState);
        initData();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        for (BasePresenter basePresenter : presenterList) {
            if (basePresenter != null) {
                basePresenter.detech();
            }
        }
        presenterList.clear();
        presenterList = null;
    }
}
