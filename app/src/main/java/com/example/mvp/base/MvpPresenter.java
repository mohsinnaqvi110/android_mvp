

package com.example.mvp.base;

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

}
