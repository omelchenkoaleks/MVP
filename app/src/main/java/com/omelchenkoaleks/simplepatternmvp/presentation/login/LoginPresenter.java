package com.omelchenkoaleks.simplepatternmvp.presentation.login;

import android.content.Context;
import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.data.db.DbHandler;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private Context mContext;

    private DbHandler mDbHandler;

    private String mEmail;
    private String mPassword;

    public LoginPresenter(LoginContract.View view, Context context) {
        mView = view;
        mView.setPresenter(this);
        mContext = context;
        mDbHandler = new DbHandler(mContext);
    }

    // проверим на пустоту ...
    @Override
    public boolean validateLoginFields(EditText[] fields) {
        for (EditText field : fields) {
            if (field.getText().toString().isEmpty()) {
                field.setError("Fill in the field");
                return false;
            }
        }
        validated(fields);
        return true;
    }

    private void validated(EditText[] fields) {
        mEmail = fields[0].getText().toString().trim();
        mPassword = fields[1].getText().toString().trim();
        checkCredentials(mEmail, mPassword);
    }

    private void checkCredentials(String email, String password) {
        if (mDbHandler.checkUserCredentials(email, password)) {
            mView.showSuccessfulMessage(mContext.getString(R.string.email_pass_valid_success));
            mView.navigateTo(email);
        } else {
            mView.showFailedMessage(mContext.getString(R.string.email_pass_valid_err));
        }
    }

    @Override
    public void start() {

    }
}
