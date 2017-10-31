package com.mvp.schame.basemvp.presenter;

import com.mvp.schame.basemvp.model.MVPModel;
import com.mvp.schame.basemvp.view.MVPView;

/**
 * Created by dell on 2017/10/27.
 */

public interface MVPPresenter<V extends MVPView , M extends MVPModel> {

    void attach(V view);

    void destroy();

    M bindModel();

}
