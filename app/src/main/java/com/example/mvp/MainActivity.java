package com.example.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityMvpView {

    MainActivityPresenter <MainActivityMvpView> mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityPresenter = new MainActivityPresenter<>(this);
        mainActivityPresenter.attachView(this);

        mainActivityPresenter.showHideLoader();

    }

    @Override
    public void showLoading() {
        Toast.makeText(getApplicationContext(), "showLoading", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(getApplicationContext(), "hideLoading", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainActivityPresenter.detachView();
    }
}
