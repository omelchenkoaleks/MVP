package com.omelchenkoaleks.simplepatternmvp.presentation.register;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.data.db.DbHandler;
import com.omelchenkoaleks.simplepatternmvp.data.model.Member;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View mView;
    private Context mContext;

    private DbHandler mDbHandler;

    private String mFirstName;
    private String mLastName;
    private String mPhone;
    private String mEmail;
    private String mPassword;

    public RegisterPresenter(RegisterContract.View view, Context context) {
        mView = view;
        mContext = context;
        mView.setPresenter(this);
        mDbHandler = new DbHandler(mContext);
    }

    @Override
    public boolean validateRegisterFields(EditText[] fields) {
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
        mFirstName = fields[0].getText().toString().trim();
        mLastName = fields[1].getText().toString().trim();
        mPhone = fields[2].getText().toString().trim();
        mEmail = fields[3].getText().toString().trim();
        mPassword = fields[4].getText().toString().trim();

        Log.d("happy", "f: " 
                + mFirstName + " l: "
                + mLastName + " p: "
                + mPhone + " e: "
                +  mEmail + " p: "
                + mPassword);

        if (savingData(mFirstName, mLastName, mPhone, mEmail, mPassword)) {
            mView.showSuccessfulRegister(mContext.getString(R.string.register_success));
        } else {
            mView.showErrorRegister(mContext.getString(R.string.register_error));
        }
    }

    private boolean savingData(String firstName,
                               String lastName,
                               String phone,
                               String email,
                               String password) {
        Member user = new Member(firstName, lastName, phone, email, password);
        return mDbHandler.saveUserData(user);
    }

    @Override
    public void start() {

    }
}
