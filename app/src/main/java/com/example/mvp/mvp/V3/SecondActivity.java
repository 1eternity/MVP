package com.example.mvp.mvp.V3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvp.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new TestFragment()).commit();
    }
}
