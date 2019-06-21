package com.omelchenkoaleks.simplepatternmvp.presentation.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.base.BaseActivity;
import com.omelchenkoaleks.simplepatternmvp.presentation.login.LoginActivity;
import com.omelchenkoaleks.simplepatternmvp.utils.NavigationUtil;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    private EditText mFirstNameRegisterEditText;
    private EditText mLastNameRegisterEditText;
    private EditText mPhoneRegisterEditText;
    private EditText mEmailRegisterEditText;
    private EditText mPasswordRegisterEditText;

    private Button mSubmitButton;

    private RegisterContract.Presenter mPresenter;
    private RegisterPresenter mRegisterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mFirstNameRegisterEditText = findViewById(R.id.first_name_register_edit_text);
        mLastNameRegisterEditText = findViewById(R.id.last_name_register_edit_text);
        mPhoneRegisterEditText = findViewById(R.id.phone_register_edit_text);
        mEmailRegisterEditText = findViewById(R.id.email_register_edit_text);
        mPasswordRegisterEditText = findViewById(R.id.password_register_edit_text);

        mSubmitButton = findViewById(R.id.submit_register_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.validateRegisterFields(new EditText[] {mFirstNameRegisterEditText,
                mLastNameRegisterEditText, mPhoneRegisterEditText, mEmailRegisterEditText,
                mPasswordRegisterEditText,});
            }
        });
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void showSuccessfulRegister(String message) {
        showMessageToast(message);
        navigateTo();
    }

    @Override
    public void showErrorRegister(String message) {
        showMessageToast(message);
    }

    @Override
    public void navigateTo() {
        NavigationUtil.startActivity(this,
                LoginActivity.class,
                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRegisterPresenter = new RegisterPresenter(this, this);
        mPresenter.start();
    }
}
