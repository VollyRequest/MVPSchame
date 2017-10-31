package com.mvp.schame.mvp.presenter;

import android.content.Context;

import com.mvp.schame.basemvp.presenter.base.BasePresenter;
import com.mvp.schame.mvp.model.MainModel;
import com.mvp.schame.mvp.view.MainActivity;

/**
 * Created by dell on 2017/10/31.
 */

public class MainPresenter extends BasePresenter<MainActivity, MainModel> {
    public MainPresenter(Context context) {
        super(context);
    }

    @Override
    public MainModel bindModel() {
        return new MainModel();
    }
}
