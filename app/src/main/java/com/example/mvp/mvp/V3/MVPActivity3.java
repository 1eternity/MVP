package com.example.mvp.mvp.V3;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.mvp.V3.baseMVP.BaseActivity;
import com.example.mvp.mvp.V3.baseMVP.BasePresenter;
import com.example.mvp.mvp.V3.presenter.MainPresenter;
import com.example.mvp.mvp.V3.presenter.TengPresenter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;

public class MVPActivity3 extends BaseActivity/*<MainPresenter>*/ implements MainContract.IMainView {

    private TextView showText,showText1;
    private AlertDialog alertDialog;

    @Inject
    MainPresenter mainPresenter;

    @Inject
    TengPresenter tengPresenter;

    @Override
    protected void initLayout(@Nullable Bundle saveInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        showText = $(R.id.showText);
        showText1 = $(R.id.showText1);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        alertDialog = dialog.create();
    }

    @Override
    protected void initData() {
        mainPresenter.handlerData();
        tengPresenter.handlerData();
    }

    @Override
    protected List<BasePresenter> setPresenter(List<BasePresenter> presenterList) {
        presenterList.add(mainPresenter);
        presenterList.add(tengPresenter);
        return presenterList;
    }

//    @Override
//    protected MainContract.IMainPresenter setPresenter() {
////        return new MainPresenter();
//        return null;
//    }

    @Override
    protected void initInJect() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showDialog() {
        alertDialog.setTitle("加载中");
        alertDialog.setMessage("数据加载中");
        alertDialog.show();
    }

    @Override
    public void success(final String connect) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.dismiss();
                showText.setText(connect);
            }
        });
    }

    @Override
    public void tendSuccess(final String coooect) {
//        Thread.sleep(2000);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alertDialog.dismiss();
                showText1.setText(coooect);
            }
        });
    }
}
