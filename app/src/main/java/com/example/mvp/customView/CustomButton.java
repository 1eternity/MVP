package com.example.mvp.customView;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Date:2020/6/16 0016
 * Time:9:50
 * author:liguoqiang
 */
public class CustomButton extends View {
    private static final String TAG = "DispatchingEvents";
    private int lastX;
    private int lastY;
    private Scroller scroller;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: view");
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
//                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                ((View) getParent()).scrollBy(-offsetX, -offsetY);  //这是一个普适的公式，谁要滑动，就找谁的父亲去调用scrollBy，然后方向取反
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //判断滚动操作是否已经完成了，如果还没完成的话，那就继续调用scrollTo()方法
        if (scroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate(); //刷新界面
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //滚动开始时的x坐标，滚动开始时的y坐标，横向滚动的距离（正值向左滚，反之向右滚），纵向滚动的距离(正值向上滚，反之向下滚)
        scroller.startScroll(scrollX, 0, delta, 0, 2000);
        invalidate();
    }

    public void smoothScrollTo1() {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(this, "translationX", 200);
        translationX.setDuration(300);
        translationX.start();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "dispatchTouchEvent: view");
        return super.dispatchTouchEvent(event);
    }
}
