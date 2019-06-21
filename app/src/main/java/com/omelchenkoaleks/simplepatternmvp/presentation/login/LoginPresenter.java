package com.omelchenkoaleks.simplepatternmvp.presentation.login;

import android.content.Context;
import android.widget.EditText;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private Context mContext;

    // TODO: позже дописать ... добавить в конструктор не забыть...
//    private DbHandler mDbHandler;

    private String mEmail;
    private String mPassword;

    public LoginPresenter(LoginContract.View view, Context context) {
        mView = view;
        mView.setPresenter(this);
        mContext = context;
        // mDbHandler = new DbHandler(mContext);
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
    }

    @Override
    public void start() {

    }
}
