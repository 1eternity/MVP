package com.example.mvp.mvp.V3.proxy;

import com.example.mvp.mvp.V3.baseMVP.IBaseView;

/**
 * Date:2020/6/8 0008
 * Time:17:59
 * author:liguoqiang
 */
public class ProxyFragment<V extends IBaseView> extends ProxyImpl {
    public ProxyFragment(IBaseView view) {
        super(view);
    }
}
