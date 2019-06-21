package com.omelchenkoaleks.simplepatternmvp.data.model;

public class Member {
    private int mUserId;
    private String mUserFirstName;
    private String mUserLastName;
    private String mUserPhone;
    private String mUserEmail;
    private String mUserPassword;

    public Member() {
    }

    public Member(int userId,
                  String userFirstName,
                  String userLastName,
                  String userPhone,
                  String userEmail,
                  String userPassword) {
        mUserId = userId;
        mUserFirstName = userFirstName;
        mUserLastName = userLastName;
        mUserPhone = userPhone;
        mUserEmail = userEmail;
        mUserPassword = userPassword;
    }

    public Member(String userFirstName,
                  String userLastName,
                  String userPhone,
                  String userEmail,
                  String userPassword) {
        mUserFirstName = userFirstName;
        mUserLastName = userLastName;
        mUserPhone = userPhone;
        mUserEmail = userEmail;
        mUserPassword = userPassword;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getUserFirstName() {
        return mUserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        mUserFirstName = userFirstName;
    }

    public String getUserLastName() {
        return mUserLastName;
    }

    public void setUserLastName(String userLastName) {
        mUserLastName = userLastName;
    }

    public String getUserPhone() {
        return mUserPhone;
    }

    public void setUserPhone(String userPhone) {
        mUserPhone = userPhone;
    }

    public String getUserEmail() {
        return mUserEmail;
    }

    public void setUserEmail(String userEmail) {
        mUserEmail = userEmail;
    }

    public String getUserPassword() {
        return mUserPassword;
    }

    public void setUserPassword(String userPassword) {
        mUserPassword = userPassword;
    }
}
