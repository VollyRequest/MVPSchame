package com.mvp.schame.basemvp.view.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mvp.schame.basemvp.presenter.MVPPresenter;
import com.mvp.schame.basemvp.view.MVPView;

/**
 * Created by dell on 2017/10/27.
 */

public abstract class MvpBaseActivity<P extends MVPPresenter> extends Activity implements MVPView<P> {

    private P presenter ;

    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = this ;
        presenter = bindPresenter();
        if(null != presenter){
            presenter.attach(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != presenter){
            presenter.destroy();
        }
    }

    public P getPresenter(){
        if(null == presenter){
            throw new NullPointerException("please binding presenter");
        }
        return presenter;
    }
}
