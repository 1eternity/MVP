package com.example.mvp.mvp.V2.baseMVP;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

public class BasePresenter<V extends IBaseView, M extends BaseModel> implements IBasePresenter {
    //    protected V mView;
    private SoftReference<IBaseView> mReferenceView;
    private V mProxyView;
    private M mModel;

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

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        if (type != null) {
            Type[] types = type.getActualTypeArguments();
            try {
                mModel = (M) ((Class<?>) types[1]).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public V getView() {
//        return (V) mReferenceView.get();
        return mProxyView;
    }

    public M getModel() {
        return mModel;
    }

    @Override
        public void detach() {
//        mView = null;
        mReferenceView.clear();
        mReferenceView = null;
    }
}
