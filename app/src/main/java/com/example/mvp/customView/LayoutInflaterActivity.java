package com.example.mvp.customView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.mvp.R;

public class LayoutInflaterActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
//    https://www.jianshu.com/p/c92243287793
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_inflater);
        frameLayout = findViewById(R.id.frameLayout);
        LayoutInflater inflater = LayoutInflater.from(this);
        //root 为null时 第一个参数中最外层的布局大小无效  buton_layout中的button的大小会失效
        View inflate = inflater.inflate(R.layout.buton_layout, frameLayout);
//        inflater.removeView(inflate);
        frameLayout.addView(inflate);

    }
}
