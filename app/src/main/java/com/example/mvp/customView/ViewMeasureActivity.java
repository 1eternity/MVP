package com.example.mvp.customView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.utils.DisplayUtil;

public class ViewMeasureActivity extends AppCompatActivity {
    private static final String TAG = "_ViewMeasureActivity";
    private Button btnView;
    private LinearLayout absoluteLayout;
    private int x, lastX;
    private int y, lastY;
    private int rawX;
    private int rawY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_measure);
        btnView = findViewById(R.id.btnView);
        absoluteLayout = findViewById(R.id.absoluteLayout);

        btnView.post(new Runnable() {
            @Override
            public void run() {
                int width = absoluteLayout.getWidth();
                Log.i(TAG, "onCreate: 父布局的宽度= " + DisplayUtil.px2dip(ViewMeasureActivity.this, width));
                int height = absoluteLayout.getHeight();
                Log.i(TAG, "onCreate: 父布局的高度= " + DisplayUtil.px2dip(ViewMeasureActivity.this, height));

                int btnViewWidth = btnView.getWidth();
                Log.i(TAG, "onCreate: 按钮的宽度= " + DisplayUtil.px2dip(ViewMeasureActivity.this, btnViewWidth));
                int btnViewHeight = btnView.getHeight();
                Log.i(TAG, "onCreate: 按钮的高度= " + DisplayUtil.px2dip(ViewMeasureActivity.this, btnViewHeight));

                int left = btnView.getLeft();
                Log.i(TAG, "onCreate: left= " + DisplayUtil.px2dip(ViewMeasureActivity.this, left));

                int right = btnView.getRight();
                Log.i(TAG, "onCreate: right=" + DisplayUtil.px2dip(ViewMeasureActivity.this, right));

                int top = btnView.getTop();
                Log.i(TAG, "onCreate: top= " + DisplayUtil.px2dip(ViewMeasureActivity.this, top));

                int bottom = btnView.getBottom();
                Log.i(TAG, "onCreate: bottom= " + DisplayUtil.px2dip(ViewMeasureActivity.this, bottom));
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: getX=" + view.getX());
                Log.i(TAG, "onClick: getY=" + view.getY());
            }
        });

        btnView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = (int) motionEvent.getX();
                        lastY = (int) motionEvent.getY();
                        Log.i(TAG, "onTouch_down: lastX=" + lastX);
                        Log.i(TAG, "onTouch_down: lastY=" + lastY);
//                        rawX = (int) motionEvent.getRawX();
//                        rawY = (int) motionEvent.getRawY();
//                        Log.i(TAG, "onTouch_down: getRawX=" + rawX);
//                        Log.i(TAG, "onTouch_down: getRawY=" + rawY);
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        x = (int) motionEvent.getX();
//                        y = (int) motionEvent.getY();
//                        Log.i(TAG, "onTouch_move: getX=" + x);
//                        Log.i(TAG, "onTouch_move: getY=" + y);
                        int offsetX = x - lastX;
                        int offsetY = y - lastY;
                        Log.i(TAG, "onTouch: offsetX=" + x + "-" + lastX + "=" + offsetX);
                        Log.i(TAG, "onTouch: offsetY=" + y + "-" + lastY + "=" + offsetY);
//                        rawX = motionEvent.getRawX();
//                        rawY = motionEvent.getRawY();
//                        Log.i(TAG, "onTouch_move: getRawX=" + rawX);
//                        Log.i(TAG, "onTouch_move: getRawY=" + rawY);
//                        view.layout(view.getLeft()+offsetX,view.getTop()+offsetY,view.getRight()+offsetX,view.getBottom()+offsetY);
//                        view.offsetLeftAndRight(offsetX);
//                        view.offsetTopAndBottom(offsetY);
//                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
//                        layoutParams.leftMargin=view.getLeft()+offsetX;
//                        layoutParams.topMargin=view.getTop()+offsetY;
//                        view.setLayoutParams(layoutParams);
//                        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
//                        layoutParams.leftMargin = view.getLeft() + offsetX;
//                        layoutParams.topMargin = view.getTop() + offsetY;
//                        view.setLayoutParams(layoutParams);

                        break;
                    case MotionEvent.ACTION_UP:
//                        x = (int) motionEvent.getX();
//                        y = (int) motionEvent.getY();
//                        Log.i(TAG, "onTouch_up: getX=" + x);
//                        Log.i(TAG, "onTouch_up: getY=" + y);
//                        rawX = (int) motionEvent.getRawX();
//                        rawY = (int) motionEvent.getRawY();
//                        Log.i(TAG, "onTouch_up: getRawX=" + rawX);
//                        Log.i(TAG, "onTouch_up: getRawY=" + rawY);
                        break;
                }
                return false;
            }
        });

    }
}
