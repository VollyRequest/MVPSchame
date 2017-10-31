package com.mvp.schame.basemvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.schame.basemvp.presenter.MVPPresenter;
import com.mvp.schame.basemvp.view.MVPView;

/**
 * Created by dell on 2017/10/27.
 * 在创建时初始化Presenter，并绑定此view
 */

public abstract class MvpBaseFragment<P extends MVPPresenter> extends Fragment implements MVPView<P> {

    private P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = bindPresenter();
        if (null != presenter) {
            presenter.attach(this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != presenter) {
            presenter.destroy();
        }
    }

    protected P getPresenter() {
        if (null == presenter) {
            throw new NullPointerException("Please binding presenter");
        }
        return presenter;
    }
}
