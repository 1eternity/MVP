package com.example.mvp.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mvp.R;

/**
 * Date:2020/6/22 0022
 * Time:14:46
 * author:liguoqiang
 */
public class RectView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);  //Paint.ANTI_ALIAS_FLAG  是使位图抗锯齿的标志
    private int mColor = Color.RED;

    public RectView(Context context) {
        super(context);
        initDraw();
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        mColor= typedArray.getColor(R.styleable.RectView_rect_color,Color.RED);
        typedArray.recycle();
        initDraw();
    }

    public RectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private void initDraw() {
        paint.setColor(mColor);
        paint.setStrokeWidth((float) 1.5); //当画笔样式为STROKE或FILL_OR_STROKE时，设置笔刷的粗细度

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight() - getPaddingTop() - getPaddingBottom();
        canvas.drawRect(0 + getPaddingLeft(), 0 + getPaddingTop(), width + getPaddingRight(), height + getPaddingBottom(), paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(width / 2, height / 2, height / 2, paint);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        //当设置为wrap_content,mode就是AT_MOST
        //当设置为match_parent&fill_parent,mode就是EXACTLY
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(600, 600);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(600, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, 600);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
