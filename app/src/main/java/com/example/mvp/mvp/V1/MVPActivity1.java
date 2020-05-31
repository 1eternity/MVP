package com.example.mvp.mvp.V1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.mvp.V1.presenter.MainPresenter;

public class MVPActivity1 extends AppCompatActivity implements MainContract.IMainView {
    private TextView showText;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        showText = findViewById(R.id.showText);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        alertDialog = dialog.create();
        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.handlerData();
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
