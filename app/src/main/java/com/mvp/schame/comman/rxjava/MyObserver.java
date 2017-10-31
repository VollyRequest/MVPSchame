package com.mvp.schame.comman.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/10/27.
 *
 *  在Presenter中，使用Observer
 */

public abstract class MyObserver<T> implements Observer<T> {
    private RxLifeManager mRxLifeManager;

    /**
     *  在使用Rx完成异步时使用
     * @param rxLifeManager
     */
    public MyObserver(RxLifeManager rxLifeManager){
        this.mRxLifeManager = rxLifeManager;
    }

    /**
     * 没有异步请求
     */
    public MyObserver(){}

    /**
     *  在Observable.subscribe(this)时，回调此方法，通过mRxLifeManager将d交由BasePresenter.mCompositeDisposable管理
     * @param d 响应事件流得到的值事件(即，网络请求的响应)，数据资源
     */
    @Override
    public void onSubscribe(Disposable d) {
        if(null !=mRxLifeManager){
            mRxLifeManager.addObserver(d);
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {

    }


}
