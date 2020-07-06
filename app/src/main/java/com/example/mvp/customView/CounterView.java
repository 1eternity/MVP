package com.example.mvp.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Date:2020/6/30 0030
 * Time:13:57
 * author:liguoqiang
 */
public class CounterView extends View implements View.OnClickListener, View.OnLongClickListener {

    private Paint mPaint;
    private Rect mBounds;
    private int mCount;
    public CounterView(Context context) {
        super(context);
    }

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public CounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(30);
        String text = String.valueOf(mCount);
        mPaint.getTextBounds(text,0,text.length(),mBounds);
        float textWidth=mBounds.width();
        float textHeight=mBounds.height();
        canvas.drawText(text,getWidth()/2-textWidth/2,getHeight()/2+textHeight/2,mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawLine(0,0,getWidth(),getHeight(),mPaint);
        canvas.drawLine(0,getHeight(),getWidth(),0,mPaint);
    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();
    }

    @Override
    public boolean onLongClick(View v) {
        for (int i = 0; i < 10; i++) {
            mCount++;
            invalidate();
        }
        return false;
    }
}
