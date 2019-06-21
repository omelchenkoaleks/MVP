package com.omelchenkoaleks.simplepatternmvp.presentation;

import android.os.Bundle;

import com.omelchenkoaleks.simplepatternmvp.R;
import com.omelchenkoaleks.simplepatternmvp.base.BaseActivity;

public class MemberActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_member;
    }
}