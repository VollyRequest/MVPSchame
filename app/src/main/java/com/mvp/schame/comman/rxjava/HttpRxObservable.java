package com.mvp.schame.comman.rxjava;

import com.mvp.schame.comman.network.excption.HttpResultFunction;
import com.trello.rxlifecycle2.LifecycleProvider;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by dell on 2017/10/31.
 *
 * @author 适用Retrofit的事件流  能不能适用泛型约束参数类型？
 */

public  class  HttpRxObservable{

    public static Observable getObservable(Observable apiObservable, LifecycleProvider lifecycle) {
        Observable observable;
        observable = apiObservable
                .compose(lifecycle.bindToLifecycle())
                .onErrorResumeNext(new HttpResultFunction<>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable ;
    }

}
