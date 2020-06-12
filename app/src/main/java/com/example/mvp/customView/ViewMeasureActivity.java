package com.example.mvp.customView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.utils.DisplayUtil;

public class ViewMeasureActivity extends AppCompatActivity {
    private static final String TAG = "_ViewMeasureActivity";
    private Button btnView;
    private LinearLayout absoluteLayout;

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
                Log.i(TAG, "onCreate: 父布局的宽度= "+DisplayUtil.px2dip(ViewMeasureActivity.this,width));
                int height = absoluteLayout.getHeight();
                Log.i(TAG, "onCreate: 父布局的高度= "+DisplayUtil.px2dip(ViewMeasureActivity.this,height));

                int btnViewWidth = btnView.getWidth();
                Log.i(TAG, "onCreate: 按钮的宽度= "+DisplayUtil.px2dip(ViewMeasureActivity.this,btnViewWidth));
                int btnViewHeight = btnView.getHeight();
                Log.i(TAG, "onCreate: 按钮的高度= "+DisplayUtil.px2dip(ViewMeasureActivity.this,btnViewHeight));

                int left = btnView.getLeft();
                Log.i(TAG, "onCreate: left= "+DisplayUtil.px2dip(ViewMeasureActivity.this,left));

                int right = btnView.getRight();
                Log.i(TAG, "onCreate: right="+DisplayUtil.px2dip(ViewMeasureActivity.this,right));

                int top = btnView.getTop();
                Log.i(TAG, "onCreate: top= "+DisplayUtil.px2dip(ViewMeasureActivity.this,top));

                int bottom = btnView.getBottom();
                Log.i(TAG, "onCreate: bottom= "+DisplayUtil.px2dip(ViewMeasureActivity.this,bottom));
            }
        });


    }
}
