package com.example.mvp.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Date:2020/6/22 0022
 * Time:14:06
 * author:liguoqiang
 */
public class MyTextView extends TextView {

    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        mPaint.setColor(Color.RED);
        canvas.drawLine(0,height/2,width,height/2,mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawLine(width/2,0,width/2,height,mPaint);
        canvas.drawLine(0,0,width,height,mPaint);
        canvas.drawLine(width,0,0,height,mPaint);


    }
}
