package com.mvp.schame.basemvp.view;

import com.mvp.schame.basemvp.presenter.MVPPresenter;

/**
 * Created by dell on 2017/10/27.
 */

public interface MVPView<P extends MVPPresenter> {

    P bindPresenter();

}
