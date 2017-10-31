package com.mvp.schame.basemvp.presenter.base;

import android.content.Context;

import com.mvp.schame.basemvp.model.MVPModel;
import com.mvp.schame.basemvp.presenter.impl.MvpBasePresenter;
import com.mvp.schame.basemvp.view.MVPView;
import com.mvp.schame.comman.rxjava.RxLifeManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/10/27.
 *
 */

public abstract class BasePresenter<V extends MVPView, M extends MVPModel> extends MvpBasePresenter<V, M> implements RxLifeManager{

    private CompositeDisposable mCompositeDisposable;
    private Context mContext;

    public BasePresenter(Context context){
        this.mContext = context.getApplicationContext() ;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public Context getContext(){
        return mContext;
    }
    // 在Observable.subscribe(observer)时，添加资源
    @Override
    public void addObserver(Disposable disposable) {
        if(null !=mCompositeDisposable){
            mCompositeDisposable.add(disposable);
        }
    }
    // 在UI销毁时，回收资源
    @Override
    public void destroy() {
        super.destroy();
        if(null !=mCompositeDisposable){
            mCompositeDisposable.dispose();
        }
    }
}
