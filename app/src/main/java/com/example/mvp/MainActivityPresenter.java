
package com.example.mvp;

import android.app.Activity;

import com.example.mvp.base.BasePresenter;
import com.raywenderlich.android.validatetor.ValidateTor;


public class MainActivityPresenter<V extends MainActivityMvpView> extends BasePresenter<V> implements MainActivityMvpPresenter<V> {

    private final Activity activity;
    ValidateTor validateTor;

    public MainActivityPresenter(Activity activity) {
        this.activity = activity;
        this.validateTor = new ValidateTor();
    }

    public void formValidation(String email, String password) {
        if (validateTor.isEmpty(email)) {
            getMvpView().showError(activity.getString(R.string.email_empty));
            return;
        } else if (!validateTor.isEmail(email)) {
            getMvpView().showError(activity.getString(R.string.email_format));
            return;
        } else if (validateTor.isEmpty(password)) {
            getMvpView().showError(activity.getString(R.string.password_empty));
            return;
        }

        getMvpView().showSuccess(activity.getString(R.string.success));

    }
}
