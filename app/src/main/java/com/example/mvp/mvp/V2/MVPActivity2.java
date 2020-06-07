package com.example.mvp.mvp.V2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.mvp.V2.presenter.MainPresenter;

import androidx.annotation.Nullable;



public class MVPActivity2 extends BaseActivity<MainContract.IMainPresenter> implements MainContract.IMainView {

    private TextView showText;
    private AlertDialog alertDialog;

    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    protected void initLayout(@Nullable Bundle saveInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        showText = $(R.id.showText);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        alertDialog = dialog.create();
    }

    @Override
    protected void initData() {
        mPresenter.handlerData();
    }

    @Override
    protected MainContract.IMainPresenter setPresenter() {
//        return new MainPresenter();
        return null;
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
}
