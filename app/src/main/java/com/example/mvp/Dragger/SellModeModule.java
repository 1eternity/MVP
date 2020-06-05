package com.example.mvp.Dragger;

import dagger.Module;
import dagger.Provides;

/**
 * Date:2020/6/5 0005
 * Time:12:03
 * author:liguoqiang
 */
@Module
public class SellModeModule {
    private int age;

    public SellModeModule(int age){
        this.age=age;
    }

    @Provides
    public int adeProvider() {
        return age;
    }

    @Provides
    public SellModeModule sellModeProvider(int age) {
        return new SellModeModule(age);
    }
}
