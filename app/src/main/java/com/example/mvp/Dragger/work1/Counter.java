package com.example.mvp.Dragger.work1;

import javax.inject.Inject;

import dagger.Module;

@Module
public class Counter {
    private int sum;
    public Counter() {

    }
    @Inject
    public Counter(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum++;
    }
}
