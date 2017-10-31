package com.mvp.schame.mvp.view;

import android.os.Bundle;

import com.mvp.schame.R;
import com.mvp.schame.basemvp.view.base.BaseActivity;
import com.mvp.schame.mvp.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("MainActivity create");
    }

    @Override
    public MainPresenter bindPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
