package com.example.mvp.mvp.V3.baseMVP;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BasePresenter<V extends IBaseView> implements IBasePresenter {
    //    protected V mView;
    private SoftReference<IBaseView> mReferenceView;
    private V mProxyView;

    @Override
    public void attach(IBaseView view) {
//        mView = (V) view;
        mReferenceView = new SoftReference<>(view);
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (mReferenceView == null || mReferenceView.get() == null) {
                    return null;
                }
                return method.invoke(mReferenceView.get(), objects);
            }
        });
    }

    public V getView() {
//        return (V) mReferenceView.get();
        return mProxyView;
    }

    @Override
    public void detech() {
//        mView = null;
        mReferenceView.clear();
        mReferenceView = null;
    }
}
