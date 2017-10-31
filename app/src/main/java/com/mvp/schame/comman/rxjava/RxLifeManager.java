package com.mvp.schame.comman.rxjava;

import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/10/27.
 */

public interface RxLifeManager {

    void addObserver(Disposable disposable);

}
