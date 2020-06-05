package com.example.mvp.Dragger;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;

/**
 * Date:2020/6/4 0004
 * Time:17:19
 * author:liguoqiang
 */
@Module
public class SellMoe {

    public int id;

    @Inject
    public SellMoe() {

    }

    public String sellMoe() {
        return "赶紧卖了个大萌";
    }
}
