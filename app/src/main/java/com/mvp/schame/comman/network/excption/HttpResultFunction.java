package com.mvp.schame.comman.network.excption;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by dell on 2017/10/31.
 */

public class HttpResultFunction<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        return Observable.error(ExceptionEngine.handleExcption(throwable));
    }
}
