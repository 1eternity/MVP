package com.example.mvp.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.mvp.R;

/**
 * Date:2020/7/1 0001
 * Time:13:59
 * author:liguoqiang
 */
public class MyListView extends ListView implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private static final String TAG = "_MyListView";
    private boolean isDeleteShown;
    private View deleteButton;
    private int selectedItem;
    private ViewGroup itemLayout;
    private OnDeleteListener listener;
    private GestureDetector gestureDetector;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }


    public void setOnDeleteListener(OnDeleteListener l) {
        listener = l;
    }


    @Override
    public boolean onDown(MotionEvent e) {
//        当按下时触发该方法，所有手势第一个必定触发该方法
        Log.i(TAG, "onDown: ");
        if(!isDeleteShown){
            //依据触摸点的坐标计算出点击的是ListView的哪个Item
            selectedItem=pointToPosition((int) e.getX(),(int) e.getY());
        }
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
//        当用户手指按下，但没有移动时触发该方法
        Log.i(TAG, "onShowPress: ");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        //当用户单击时触发
        Log.i(TAG, "onSingleTapUp: ");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        当用户手指在屏幕上拖动时触发  后面两个变量时在X,Y上移动的距离
        Log.i(TAG, "onScroll: ");
        return false;

    }

    @Override
    public void onLongPress(MotionEvent e) {
//        当用户手指在长按屏幕时触发
        Log.i(TAG, "onLongPress: ");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        当用户手指拖动后，手指离开屏幕时触发
//        这个方法常用来使手指离开后页面仍然可以滑动（速度慢慢变小）
//        后两个变量表示手指在X,Y两个方向上的速度
        Log.i(TAG, "onFling: velocityX = "+velocityX+"---velocityY = "+velocityY );
        if (!isDeleteShown && Math.abs(velocityX) > Math.abs(velocityY)) {
            deleteButton = LayoutInflater.from(getContext()).inflate(R.layout.delete_button_layout, null);
            deleteButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemLayout.removeView(deleteButton);
                    deleteButton = null;
                    isDeleteShown = false;
                    listener.onDelete(selectedItem);
                }
            });
            //getFirstVisiblePosition  显示当前屏幕最上面item的位置
            //getChildAt  在集合中返回指定位置的视图。 index:索引的位置得到的视图
            Log.i(TAG, "onFling: getFirstVisiblePosition ="+getFirstVisiblePosition()+"--selectedItem="+selectedItem);
            itemLayout = (ViewGroup) getChildAt(selectedItem - getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT); //android:layout_alignParentRight="true"
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            itemLayout.addView(deleteButton, params);
            isDeleteShown = true;
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(TAG, "onTouch: ");
        if (isDeleteShown) {
            itemLayout.removeView(deleteButton);
            deleteButton=null;
            isDeleteShown=false;
            return false;
        }else {
            return gestureDetector.onTouchEvent(event);
        }
    }

    public interface OnDeleteListener {

        void onDelete(int index);

    }
}
