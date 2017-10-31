package com.mvp.schame.basemvp.presenter.impl;

import com.mvp.schame.basemvp.model.MVPModel;
import com.mvp.schame.basemvp.presenter.MVPPresenter;
import com.mvp.schame.basemvp.view.MVPView;

/**
 * Created by dell on 2017/10/27.
 * <p>
 * model与view的bridge
 */

public abstract class MvpBasePresenter<V extends MVPView, M extends MVPModel> implements MVPPresenter<V, M> {

    private V view;
    private M model;

    public MvpBasePresenter() {
        this.model = bindModel();
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
    }

    protected M getModel() {
        if(null == model){
            throw new NullPointerException("please binding model");
        }
        return model;
    }

    protected V getView() {
        return view;
    }
}
