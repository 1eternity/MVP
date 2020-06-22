package com.example.mvp.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Date:2020/6/22 0022
 * Time:16:51
 * author:liguoqiang
 */
public class HorizontalView extends ViewGroup {
    public HorizontalView(Context context) {
        super(context);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

}
