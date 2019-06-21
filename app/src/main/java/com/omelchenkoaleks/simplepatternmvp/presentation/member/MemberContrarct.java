package com.omelchenkoaleks.simplepatternmvp.presentation.member;

import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.base.BasePresenter;
import com.omelchenkoaleks.simplepatternmvp.base.BaseView;
import com.omelchenkoaleks.simplepatternmvp.data.model.Member;

public interface MemberContrarct {
    interface Presenter extends BasePresenter {
        void getUserEmail(String email);
        void logOut(String email);
        void getUserDetail(Member user);
        void deleteAccount(String email);
        boolean validateUpdateFields(EditText[] fields);
    }

    interface View extends BaseView<Presenter> {
        void loadUserDetail(Member user);
        void showSuccess(String message);
        void showFailed(String message);
        void navigateToNextPage();
        void refreshPage(String email);
        void logOut();
    }
}
