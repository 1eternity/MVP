package com.example.mvp.mvp.V3;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.mvp.V3.baseMVP.BaseFragment;
import com.example.mvp.mvp.V3.baseMVP.BasePresenter;
import com.example.mvp.mvp.V3.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;

/**
 * Date:2020/6/8 0008
 * Time:17:06
 * author:liguoqiang
 */
public class TestFragment extends BaseFragment implements MainContract.IMainView {

    @Inject
    MainPresenter mainPresenter;
    private TextView showText;

    @Override
    public void showDialog() {

    }

    @Override
    public void success(final String connect) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showText.setText(connect);
            }
        });
    }

    @Override
    public void tendSuccess(String coooect) {

    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        showText = $(R.id.showText);
    }

    @Override
    protected void initData() {
        mainPresenter.handlerData();
    }

    @Override
    protected List<BasePresenter> setPresenter(List<BasePresenter> presenterList) {
        presenterList.add(mainPresenter);
        return presenterList;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_test;
    }
}
