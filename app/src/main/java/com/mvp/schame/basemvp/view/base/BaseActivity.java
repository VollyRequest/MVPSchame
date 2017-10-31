package com.mvp.schame.basemvp.view.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.mvp.schame.basemvp.presenter.MVPPresenter;
import com.mvp.schame.basemvp.view.impl.MvpBaseActivity;

/**
 * Created by dell on 2017/10/27.
 *
 * @author fzc
 *         保持洁净，只负责生命周期(组件，toast,dialog)
 */

public abstract class BaseActivity<P extends MVPPresenter> extends MvpBaseActivity<P> {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showToast(String msg) {
        SuperActivityToast.create(mActivity, Style.TYPE_STANDARD).
                setText(msg).
                setAnimations(Style.ANIMATIONS_SCALE).
                setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE_GREY)).
                setFrame(Style.FRAME_STANDARD).
                setDuration(Style.DURATION_SHORT).
                show();
    }

}
