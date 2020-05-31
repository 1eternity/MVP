package com.example.mvp.dynamicAgentMode;

import java.lang.reflect.Proxy;

public class MainProgram {
    //https://blog.csdn.net/mcryeasy/article/details/83689396

    public static void main(String[] arr){

        Subject realSubject = new RealSubject();
        SubjectInvocationHandler handler = new SubjectInvocationHandler(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);

        //输出代理类对象
//        System.out.println("Proxy : "+ subject.getClass().getName());
//        System.out.println("Proxy super : "+ subject.getClass().getSuperclass().getName());
//        System.out.println("Proxy interfaces : "+ subject.getClass().getInterfaces()[0].getName());

        subject.sayGoodsBye();
        System.out.println("----------------");
        subject.sayHello("动态代理");
    }
}
