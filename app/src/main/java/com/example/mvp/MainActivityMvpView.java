
package com.example.mvp;
import com.example.mvp.base.MvpView;

/**
 * All interfaces for view
 * @param <V>
 */
public interface MainActivityMvpView extends MvpView {

    void showError(String error);

    void showSuccess(String result);
}
