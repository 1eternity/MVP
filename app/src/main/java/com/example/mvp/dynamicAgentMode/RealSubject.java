package com.example.mvp.dynamicAgentMode;

public class RealSubject implements Subject {

    @Override
    public void sayGoodsBye() {
        System.out.println("RealSubject sayGoodsBye");
    }

    @Override
    public void sayHello(String str) {
        System.out.println("RealSubject sayHello "+str);
    }
}
