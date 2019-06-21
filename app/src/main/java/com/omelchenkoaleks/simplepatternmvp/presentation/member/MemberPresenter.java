package com.omelchenkoaleks.simplepatternmvp.presentation.member;

import android.content.Context;
import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.data.db.DbHandler;
import com.omelchenkoaleks.simplepatternmvp.data.model.Member;

public class MemberPresenter implements MemberContrarct.Presenter {
    private MemberContrarct.View mView;
    private Context mContext;
    private DbHandler mDbHandler;

    private String mFirstName;
    private String mLastName;
    private String mPhone;
    private String mEmail;
    private String mPassword;

    public MemberPresenter(MemberContrarct.View view, Context context) {
        mView = view;
        mContext = context;
        mView.setPresenter(this);
        mDbHandler = new DbHandler(mContext);
    }

    @Override
    public void getUserEmail(String email) {
        mDbHandler.getUserDetails(email);
        getUserDetail(mDbHandler.getUserDetails(email));
    }

    @Override
    public void getUserDetail(Member user) {
        mView.loadUserDetail(user);
    }

    @Override
    public void deleteAccount(String email) {
        mDbHandler.deleteAccount(email);
        if (!mDbHandler.deleteAccount(email)) {
            mView.showSuccess(mContext.getString(R.string.delete_success));
            mView.navigateToNextPage();
        } else {
            mView.showFailed(mContext.getString(R.string.delete_error));
        }
    }

    @Override
    public boolean validateUpdateFields(EditText[] fields) {
        for (EditText fieldCounter : fields) {
            if (fieldCounter.getText().toString().isEmpty()) {
                fieldCounter.setError("Fill in the field");
                return false;
            }
        }

        validated(fields);
        return false;
    }

    private void validated(EditText[] fields) {
        mFirstName = fields[0].getText().toString().trim();
        mLastName = fields[1].getText().toString().trim();
        mPhone = fields[2].getText().toString().trim();
        mEmail = fields[3].getText().toString().trim();
        mPassword = fields[4].getText().toString().trim();

        if (updateUserData(mFirstName, mLastName, mPhone, mEmail, mPassword) == 1) {
            mView.showSuccess(mContext.getString(R.string.update_success));
            mView.refreshPage(mEmail);
        } else {
            mView.showFailed(mContext.getString(R.string.update_error));
        }
    }

    private int updateUserData(String firstName,
                               String lastName,
                               String phone,
                               String email,
                               String password) {
        Member user = new Member(firstName, lastName, phone, email, password);
        return mDbHandler.updateUserData(user, email);
    }

    @Override
    public void logOut(String email) {
        if (email != null) {
            mView.logOut();
        }
    }

    @Override
    public void start() {

    }
}
