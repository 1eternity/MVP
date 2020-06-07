package com.example.mvp.Dragger.work;

import javax.inject.Inject;

import dagger.Module;

@Module
public class HaHa {

    private int age;

    @Inject
    public HaHa(int age) {
        this.age = age;
    }

    public String ha() {
        return "我特么" + age + "岁了抬起杠来依然是个扛把子";
    }
}
