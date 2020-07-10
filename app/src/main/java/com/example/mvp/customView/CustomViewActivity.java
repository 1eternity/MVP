package com.example.mvp.customView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mvp.R;
import com.example.mvp.customView.aaa.DatePickerView;
import com.example.mvp.customView.aaa.LoopView;

import java.util.ArrayList;
import java.util.List;

public class CustomViewActivity extends AppCompatActivity {
    private static final String TAG = "CustomViewActivity";
    private LoopView loopView;
    private DatePickerView datePickerView;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        loopView = findViewById(R.id.loopView);
        datePickerView = findViewById(R.id.datePickerView);
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            list.add(""+i);
        }

        loopView.setDataList(list);

        loopView.setLoopListener(new LoopView.LoopScrollListener() {
            @Override
            public void onItemSelect(int item) {
                Log.i(TAG, "onItemSelect: "+item+"---"+loopView.getSelectedItem());
            }
        });

        datePickerView.setArrayList(list);
        datePickerView.setCyclic(true);
        datePickerView.setCanScroll(true);



    }
}
