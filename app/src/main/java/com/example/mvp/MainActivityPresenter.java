
package com.example.mvp;
import android.app.Activity;
import android.os.Handler;

import com.example.mvp.base.BasePresenter;


public class MainActivityPresenter<V extends MainActivityMvpView> extends BasePresenter<V> implements MainActivityMvpPresenter<V> {

    private final Activity activity;

    public MainActivityPresenter(Activity activity) {
        this.activity = activity;
    }

    public void showHideLoader() {
        getMvpView().showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().hideLoading();
            }
        }, 1000);
    }

}
