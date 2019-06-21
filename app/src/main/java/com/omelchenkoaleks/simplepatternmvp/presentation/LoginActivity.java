package com.omelchenkoaleks.simplepatternmvp.presentation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.base.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    private LoginContract.Presenter mPresenter;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mEmailEditText = findViewById(R.id.email_input_edit_text);
        mPasswordEditText = findViewById(R.id.password_input_edit_text);
        mLoginButton = findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("happy", "Email: " + mEmailEditText.getText().toString().trim() +
                " Password: " + mPasswordEditText.getText().toString().trim());
                mLoginPresenter.validateLoginFields(new EditText[] {mEmailEditText, mPasswordEditText});
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void showSuccessfulMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void showFailedMessage(String message) {
        showMessageToast(message);
    }

    @Override
    public void navigateTo(String email) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginPresenter = new LoginPresenter(this, this);
    }
}
