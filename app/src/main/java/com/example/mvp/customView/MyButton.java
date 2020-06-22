package com.example.mvp.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Date:2020/6/18 0018
 * Time:13:57
 * author:liguoqiang
 */
public class MyButton extends Button {
    private static final String TAG = "DispatchingEvents";

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: view");
        return super.onTouchEvent(event);
//        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "dispatchTouchEvent: view");
        return super.dispatchTouchEvent(event);
//        return true;
    }
}
