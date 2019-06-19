package com.example.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityMvpView {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.done)
    Button done;
    @BindView(R.id.result)
    TextView result;

    MainActivityPresenter <MainActivityMvpView> mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainActivityPresenter = new MainActivityPresenter<>(this);
        mainActivityPresenter.attachView(this);

        done.setOnClickListener(v -> mainActivityPresenter.formValidation(email.getText().toString(), password.getText().toString()));

    }

    @Override
    public void showError(String error) {
        result.setText(error);
    }

    @Override
    public void showSuccess(String resultString) {
        result.setText(resultString);
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
