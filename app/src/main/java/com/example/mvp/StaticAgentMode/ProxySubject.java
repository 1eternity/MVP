package com.example.mvp.StaticAgentMode;

public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void sayGoodsBye() {
        System.out.println("ProxySubject sayGoodByte begin");
        subject.sayGoodsBye();
        System.out.println("ProxySubject sayGoodsBye end");
    }

    @Override
    public void sayHello(String str) {
        System.out.println("ProxySubject sayHello begin");
        subject.sayHello(str);
        System.out.println("ProxySubject sayHello end");
    }

}
