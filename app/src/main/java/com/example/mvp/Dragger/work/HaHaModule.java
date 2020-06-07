package com.example.mvp.Dragger.work;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HaHaModule {
    private int age;

    public HaHaModule(int age) {
        this.age = age;
    }

    @Provides
    public int ageProvider() {
        return age;
    }

    @Singleton
    @Provides
    public HaHa haHaProvider(int age) {
        return new HaHa(age);
    }
}
