package com.mvp.schame.basemvp.view.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.schame.basemvp.presenter.MVPPresenter;
import com.mvp.schame.basemvp.view.impl.MvpBaseFragment;

/**
 * Created by dell on 2017/10/27.
 */

public abstract class BaseFragment<P extends MVPPresenter> extends MvpBaseFragment<P> {

    public Activity mActivity;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mActivity = getActivity();
        if (null == view) {
            view = getRootView(inflater, container);
            initView(view);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (null != parent) {
            parent.removeView(view);
        }
        return view;

    }

    protected abstract void initView(View view);

    public abstract View getRootView(LayoutInflater inflater, @Nullable ViewGroup container);
}
