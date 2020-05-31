package com.example.mvp.StaticAgentMode;

public class MainProgram {

    public static void main(String[] arr) {
        //被代理的对象，某些情况下 我们不希望修改现有的代码，我们采用代理来间接访问
        RealSubject realSubject = new RealSubject();
        //代理类对象
        ProxySubject proxySubject=new ProxySubject(realSubject);

        proxySubject.sayGoodsBye();
        System.out.println("&&&&&&&&&&&&&&");
        proxySubject.sayHello("hahahahahah");
    }
}
