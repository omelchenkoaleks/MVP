package com.omelchenkoaleks.simplepatternmvp.presentation.register;

import android.widget.EditText;

import com.omelchenkoaleks.simplepatternmvp.base.BasePresenter;
import com.omelchenkoaleks.simplepatternmvp.base.BaseView;

public interface RegisterContract {
    interface Presenter extends BasePresenter {
        boolean validateRegisterFields(EditText[] fields);
    }

    interface View extends BaseView<Presenter> {
        void showSuccessfulRegister(String message);
        void showErrorRegister(String message);
        void navigateTo();
    }
}
