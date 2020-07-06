package com.example.mvp.customView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mvp.R;

import java.util.ArrayList;
import java.util.List;

public class MyListViewActivity extends AppCompatActivity {

    private MyListView listView;
    private MyAdapter adapter;

    private List<String> contentList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);
        listView = findViewById(R.id.listView);
        initList();
        adapter=new MyAdapter(this,0,contentList);
        listView.setAdapter(adapter);
        listView.setOnDeleteListener(new MyListView.OnDeleteListener() {
            @Override
            public void onDelete(int index) {
                contentList.remove(index);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void initList() {
        contentList.add("Content Item 1");
        contentList.add("Content Item 2");
        contentList.add("Content Item 3");
        contentList.add("Content Item 4");
        contentList.add("Content Item 5");
        contentList.add("Content Item 6");
        contentList.add("Content Item 7");
        contentList.add("Content Item 8");
        contentList.add("Content Item 9");
        contentList.add("Content Item 10");
        contentList.add("Content Item 11");
        contentList.add("Content Item 12");
        contentList.add("Content Item 13");
        contentList.add("Content Item 14");
        contentList.add("Content Item 15");
        contentList.add("Content Item 16");
        contentList.add("Content Item 17");
        contentList.add("Content Item 18");
        contentList.add("Content Item 19");
        contentList.add("Content Item 20");
    }
}
