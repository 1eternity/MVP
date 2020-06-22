package com.example.mvp.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvp.R;

/**
 * Date:2020/6/22 0022
 * Time:16:07
 * author:liguoqiang
 */
public class TitleBar extends RelativeLayout {

    private ImageView iv_titlebar_left;
    private ImageView iv_titlebar_right;
    private TextView tv_titlebar_title;
    private RelativeLayout layout_titlebar_rootlayout;
    private int mColor = Color.WHITE;
    private int mTextColor = Color.BLACK;
    private String titlename="标题";

    public TitleBar(Context context) {
        super(context);
        initView(context);
    }


    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        mColor = typedArray.getColor(R.styleable.TitleBar_title_bg, Color.WHITE);
        mTextColor = typedArray.getColor(R.styleable.TitleBar_title_text_color, Color.BLACK);
        titlename = typedArray.getString(R.styleable.TitleBar_title_text);
        typedArray.recycle();
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_customtitle, this, true);
        iv_titlebar_left = findViewById(R.id.iv_titlebar_left);
        iv_titlebar_right = findViewById(R.id.iv_titlebar_right);
        tv_titlebar_title = findViewById(R.id.tv_titlebar_title);
        layout_titlebar_rootlayout = findViewById(R.id.layout_titlebar_rootlayout);
        layout_titlebar_rootlayout.setBackgroundColor(mColor);
        tv_titlebar_title.setTextColor(mTextColor);
        tv_titlebar_title.setText(titlename);
    }

    public void setTitle(String titlename) {
        tv_titlebar_title.setText(titlename);
    }

    public void setLeftListener(OnClickListener onClickListener) {
        iv_titlebar_left.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        iv_titlebar_right.setOnClickListener(onClickListener);
    }

}
