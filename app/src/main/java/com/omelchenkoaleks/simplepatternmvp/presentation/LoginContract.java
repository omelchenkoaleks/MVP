package com.omelchenkoaleks.simplepatternmvp.presentation;

import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.base.BasePresenter;
import com.omelchenkoaleks.simplepatternmvp.base.BaseView;

public interface LoginContract {
    interface Presenter extends BasePresenter {
        boolean validateLoginFields(EditText[] fields);
    }

    interface View extends BaseView<Presenter> {
        void showSuccessfulMessage(String message);
        void showFailedMessage(String message);
        void navigateTo(String email);
    }
}
