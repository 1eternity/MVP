package com.example.mvp.mvp.V3.proxy;

import com.example.mvp.mvp.V3.baseMVP.BasePresenter;
import com.example.mvp.mvp.V3.baseMVP.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2020/6/8 0008
 * Time:17:54
 * author:liguoqiang
 */
public class ProxyImpl implements IProxy {

    private IBaseView mView;
    private List<BasePresenter> presenterList;

    public ProxyImpl(IBaseView view) {
        this.mView = view;
        presenterList = new ArrayList<>();
    }

    public List<BasePresenter> getPresenterList() {
        return presenterList;
    }

    @Override
    public void bindPresenter() {
        for (BasePresenter basePresenter : presenterList) {
            if (basePresenter != null) {
                basePresenter.attach(mView);
            }
        }
    }

    @Override
    public void unbindPresenter() {
        for (BasePresenter basePresenter : presenterList) {
            if (basePresenter != null) {
                basePresenter.detech();
            }
        }
        presenterList.clear();
        presenterList = null;
    }
}
