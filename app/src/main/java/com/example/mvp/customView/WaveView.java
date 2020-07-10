package com.example.mvp.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.mvp.R;
import com.example.mvp.utils.DisplayUtil;

/**
 * Date:2020/7/8 0008
 * Time:10:04
 * author:liguoqiang
 */
public class WaveView extends View {
    private static final String TAG = "_WaveView";
    private int mMode;
    private int mWaveCount;
    private int mWaveWidth;
    private int mColor;
    private int mWidth;
    private Context mContext;
    private float mRectWidth;
    private float mRectHeight;
    private int mHeight;
    private Paint mPaint;
    private float mWaveHeight;

    public WaveView(Context context) {
        super(context);
        mContext = context;
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.WaveView);
        mMode = type.getInt(R.styleable.WaveView_mode, -1);
        mWaveCount = type.getInt(R.styleable.WaveView_waveCount, 10);
        mWaveWidth = type.getInt(R.styleable.WaveView_waveWidth, 20);
        mColor = type.getColor(R.styleable.WaveView_android_color, Color.parseColor("#2C97DE"));
        type.recycle();

        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
            mRectWidth = (float) (mWidth * 0.8);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            mWidth = DisplayUtil.dip2px(mContext, 200);
            mRectWidth = (float) (mWidth * 0.8);
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
            mRectHeight = (float) (mHeight * 0.8);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            mHeight = DisplayUtil.dip2px(mContext, 100);
            mRectHeight = (float) (mHeight * 0.8);
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mColor);
        float padding = (mWidth - mRectWidth) / 2;
        canvas.drawRect(padding, padding, mRectWidth + padding, mRectHeight + padding, mPaint);
        //计算每个三角形的高
        mWaveHeight = mRectHeight / mWaveCount;

        if (mMode == -2) {
            Path path = new Path();
            float startX = padding + mRectWidth;
            float startY = padding;
            path.moveTo(startX, startY);
            for (int i = 0; i < mWaveCount; i++) {
                path.lineTo(startX + mWaveWidth, mWaveHeight / 2 + mWaveHeight * i + startY);
                path.lineTo(startX, (i + 1) * mWaveHeight + startY);
                Log.i(TAG, "onDraw: lineto1=" + (mWaveHeight / 2 + mWaveHeight * i + startY) + "------lineto2=" + ((i + 1) * mWaveHeight + startY));
            }
            path.close();
            canvas.drawPath(path, mPaint);

            startX = padding;
            startY = padding;
            path.reset();
            path.moveTo(startX, startY);
            for (int i = 0; i < mWaveCount; i++) {
                path.lineTo(startX - mWaveWidth, mWaveHeight / 2 + mWaveHeight * i + startY);
                path.lineTo(startX, (i + 1) * mWaveHeight + startY);
            }
            path.close();
            canvas.drawPath(path, mPaint);
        } else if (mMode == -1) {
            float mRadius = (mRectHeight / mWaveCount) / 2; //半径
            float startX = padding + mRectWidth;
            float startY = padding;
            for (int i = 0; i < mWaveCount; i++) {
                canvas.drawCircle(startX, startY + mRadius + i * mRadius * 2, mRadius, mPaint);
            }
            startX = padding;
            startY = padding;
            for (int i = 0; i < mWaveCount; i++) {
                canvas.drawCircle(startX, startY + mRadius + i * mRadius * 2, mRadius, mPaint);
            }
        }

    }
}
