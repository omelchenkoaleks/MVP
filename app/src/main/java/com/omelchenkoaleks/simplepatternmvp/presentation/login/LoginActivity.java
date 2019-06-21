package com.omelchenkoaleks.simplepatternmvp.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.base.BaseActivity;
import com.omelchenkoaleks.simplepatternmvp.presentation.MemberActivity;
import com.omelchenkoaleks.simplepatternmvp.presentation.RegisterActivity;
import com.omelchenkoaleks.simplepatternmvp.utils.NavigationUtil;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private TextView mRegisterButtonTextView;

    private LoginContract.Presenter mPresenter;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mEmailEditText = findViewById(R.id.email_input_edit_text);
        mPasswordEditText = findViewById(R.id.password_input_edit_text);
        mLoginButton = findViewById(R.id.login_button);
        mRegisterButtonTextView = findViewById(R.id.register_button_text_view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void buttonClicked(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                mLoginPresenter.validateLoginFields(new EditText[] {mEmailEditText, mPasswordEditText});
                break;
            case R.id.register_button_text_view:
                NavigationUtil.startActivity(this, RegisterActivity.class,
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
        }
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
        NavigationUtil.startActivity(this,
                MemberActivity.class,
                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP,
                email);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginPresenter = new LoginPresenter(this, this);
    }
}
