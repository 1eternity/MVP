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

    public int age;

    @Inject
    public SellMoe(int age) {
        this.age=age;
    }

    public String sellMoe() {
        return "我特么" + age + "岁了还是可爱得要死";
    }
}
