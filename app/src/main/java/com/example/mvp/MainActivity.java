package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp.mvp.MainContract;
import com.example.mvp.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.IMainView {

    private MainPresenter mainPresenter;
    private TextView showText;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        AlertDialog.Builder  dialog = new AlertDialog.Builder(this);
        alertDialog = dialog.create();
        mainPresenter.handlerData();
        showText = (TextView) findViewById(R.id.showText);
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
