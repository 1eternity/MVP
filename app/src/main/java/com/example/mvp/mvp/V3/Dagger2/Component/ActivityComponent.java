package com.example.mvp.mvp.V3.Dagger2.Component;

import com.example.mvp.mvp.V3.Dagger2.module.ActivityModule;
import com.example.mvp.mvp.V3.MVPActivity3;

import dagger.Component;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MVPActivity3 mvpActivity3);
}
