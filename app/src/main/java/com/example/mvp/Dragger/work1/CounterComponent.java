package com.example.mvp.Dragger.work1;

import com.example.mvp.Dragger.DaggerActivity;

import dagger.Component;

@Component(modules = CounterModule.class)
public interface CounterComponent {
    void inject(DaggerActivity activity);
}
