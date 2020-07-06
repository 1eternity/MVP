package com.example.mvp.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Date:2020/7/2 0002
 * Time:9:39
 * author:liguoqiang
 */
public class PopupView extends View {
    private static final String TAG = "_PopupView";
    private int mWidth;
    private double mRectPercent = 0.8;
    private int mRectWidth;
    private int mHeight;
    private int mRectHeight;
    private Paint mPaint;

    public PopupView(Context context) {
        super(context);
    }

    public PopupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
//        AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
//        UNSPECIFIED：表示子布局想要多大就多大，很少使用
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
            mRectWidth = (int) (mWidth * mRectPercent);
        }else {
            Log.i(TAG, "onMeasure width: wrap_parent");
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
            mRectHeight = (int) (mHeight * mRectPercent + 0.1);
        }else {
            Log.i(TAG, "onMeasure height: wrap_parent");
        }
        setMeasuredDimension(mWidth, mHeight);
        Log.i(TAG, "onMeasure: mWidth=" + mWidth + "--mHeight=" + mHeight);
        Log.i(TAG, "onMeasure: mRectWidth=" + mRectWidth + "--mRectHeight=" + mRectHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.parseColor("#2C97DE"));
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(0, 0, mRectWidth, mRectHeight), 10, 10, mPaint);

        //path 用来描述绘制几何图形
        Path path = new Path();
        //moveTo 设置图形的起始点坐标
        path.moveTo(mRectWidth / 2 - 30, mRectHeight);
        //lineTo 由上一个点画一条线到指定的x,y;如果前边没有使用moveTo()指定起始点的话,我们在第一次调用该函数的时候,起始点为坐标(0,0)点上;
        path.lineTo(mRectWidth / 2, mRectHeight + 20);
        path.lineTo(mRectWidth / 2 + 30, mRectHeight);
        path.close();
        canvas.drawPath(path, mPaint);
        super.onDraw(canvas);
    }
}
