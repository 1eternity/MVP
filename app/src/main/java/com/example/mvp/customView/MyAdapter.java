package com.example.mvp.customView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mvp.R;

import java.util.List;

/**
 * Date:2020/7/1 0001
 * Time:14:29
 * author:liguoqiang
 */
public class MyAdapter extends ArrayAdapter<String> {

    public MyAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.my_list_view_item, null);
        } else {
            view = convertView;
        }
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText(getItem(position));
        return view;
    }

}