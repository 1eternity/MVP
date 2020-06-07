package com.example.mvp.Dragger;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;

/**
 * Date:2020/6/4 0004
 * Time:17:29
 * author:liguoqiang
 */
@Module
public class GangJing {
    private static final String TAG = "GangJing";
    private SellMoe sellMoe;
    @Inject
    public GangJing(SellMoe sellMoe){
        this.sellMoe=sellMoe;
    }
    public String lookAtHim(){
        sellMoe.age=2;
        Log.i(TAG, "lookAtHim: "+sellMoe.age);
        return sellMoe.sellMoe();
    }
    public void gang(Context context){
        Toast.makeText(context, "这抠脚大汉天天卖萌", Toast.LENGTH_SHORT).show();
    }
}
