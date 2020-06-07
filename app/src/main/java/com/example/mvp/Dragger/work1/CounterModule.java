package com.example.mvp.Dragger.work1;


import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class CounterModule {

    private int sum;

    public CounterModule(int sum) {
        this.sum = sum;
    }

    @Provides
    public int sumProvider() {
        return sum;
    }

    @Provides  @Named("current")
    public Counter counterModuleProvider(int sum) {
        return new Counter(sum);
    }
    @Named("total")
    @Provides
    public Counter totalModuleProvider(){
        return new Counter();
    }
}
