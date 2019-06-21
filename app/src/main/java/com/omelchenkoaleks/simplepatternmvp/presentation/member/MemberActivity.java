package com.omelchenkoaleks.simplepatternmvp.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.base.BaseActivity;
import com.omelchenkoaleks.simplepatternmvp.data.model.Member;
import com.omelchenkoaleks.simplepatternmvp.presentation.login.LoginActivity;
import com.omelchenkoaleks.simplepatternmvp.utils.NavigationUtil;

public class MemberActivity extends BaseActivity implements MemberContrarct.View {
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mPhoneEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;

    private TextView mFirstNameTextView;

    private MemberContrarct.Presenter mPresenter;
    private MemberPresenter mMemberPresenter;

    private String mFirstName;
    private String mLastName;
    private String mPhone;
    private String mEmail;
    private String mPassword;

    private int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mFirstNameEditText = findViewById(R.id.first_name_edit_text);
        mLastNameEditText = findViewById(R.id.last_name_edit_text);
        mPhoneEditText = findViewById(R.id.phone_edit_text);
        mEmailEditText = findViewById(R.id.email_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);

        mFirstNameTextView = findViewById(R.id.first_name_text_view);
    }

    public void clickOfButton(View view) {
        switch (view.getId()) {
            case R.id.edit_button:
                mMemberPresenter.validateUpdateFields(new EditText[]{mFirstNameEditText,
                        mLastNameEditText, mPhoneEditText, mEmailEditText, mPasswordEditText,});
                break;
            case R.id.delete_button:
                mMemberPresenter.deleteAccount(mEmail);
                break;
            case R.id.logout_button:
                mMemberPresenter.logOut(mEmail);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_member;
    }

    @Override
    public void setPresenter(MemberContrarct.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void loadUserDetail(Member user) {
        mId = user.getUserId();
        mFirstName = user.getUserFirstName();
        mLastName = user.getUserLastName();
        mPhone = user.getUserPhone();
        mEmail = user.getUserEmail();
        mPassword = user.getUserPassword();

        if (mFirstName != null) {
            setData();
        }
    }

    private void setData() {
        mFirstNameEditText.setText(mFirstName);
        mLastNameEditText.setText(mLastName);
        mPhoneEditText.setText(mPhone);
        mEmailEditText.setText(mEmail);
        mPasswordEditText.setText(mPassword);
    }

    @Override
    public void showMessageToast(String message) {
        super.showMessageToast(message);
    }

    @Override
    public void showSuccess(String message) {
        showMessageToast(message);
    }

    @Override
    public void showFailed(String message) {
        showMessageToast(message);
    }

    @Override
    public void navigateToNextPage() {
        NavigationUtil.startActivity(this,
                LoginActivity.class,
                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void refreshPage(String email) {
        mMemberPresenter = new MemberPresenter(this, this);
        mMemberPresenter.getUserEmail(email);
    }

    @Override
    public void logOut() {
        NavigationUtil.startActivity(this,
                LoginActivity.class,
                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEmail = getIntent().getStringExtra("wrap_detail");
        mMemberPresenter = new MemberPresenter(this, this);
        mMemberPresenter.getUserEmail(mEmail);
    }
}
