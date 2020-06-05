package com.example.mvp.Dragger;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mvp.R;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;

public class DaggerActivity extends AppCompatActivity {
    private static final String TAG = "_DaggerActivity";

    //https://blog.csdn.net/u014653815/article/details/81201865
//    https://blog.csdn.net/lisdye2/article/details/51942511
//    https://blog.csdn.net/u014653815/article/details/81214499?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-9
//    @Inject
//    SellMoe sellMoe;
//    @Inject
//    GangJing gangJing;
//    @Inject
//    SellMoe sellMoe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        //第一种方式
//        DaggerMainComponent.create().inject(this);
        //第二种方式
//        DaggerMainComponent.builder().build().inject(this);
//        DaggerMainComponent.builder().mainModuld(new MainModuld(this)).build().inject(this);

        TextView showText = findViewById(R.id.showText);
//        showText.setText(gangJing.lookAtHim());
//        gangJing.gang(this);
//
//        sellMoe.id=1;
//
//        Log.i(TAG, "onCreate id= : "+sellMoe.id);
    }
}
