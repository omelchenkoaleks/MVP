package com.omelchenkoaleks.simplepatternmvp.data.db;

import android.content.ContentValues;
import android.content.Context;

import com.omelchenkoaleks.simplepatternmvp.data.model.Member;

public class DbHandler {
    private DbHelper mDbHelper;
    Context mContext;

    public DbHandler(Context context) {
        mContext = context;
        mDbHelper = new DbHelper(mContext);
    }

    public boolean saveUserData(Member user) {
        ContentValues values = new ContentValues();
        values.put(DbTable.COL_USER_FNAME, user.getUserFirstName());
        values.put(DbTable.COL_USER_LNAME, user.getUserLastName());
        values.put(DbTable.COL_USER_PHONE, user.getUserPhone());
        values.put(DbTable.COL_USER_EMAIL, user.getUserEmail());
        values.put(DbTable.COL_USER_PASSWORD, user.getUserPassword());
        return mDbHelper.insertData(DbTable.TABLE_USER, values);
    }

    public int updateUserData(Member user, String email){
        ContentValues values = new ContentValues();
        values.put(DbTable.COL_USER_FNAME, user.getUserFirstName());
        values.put(DbTable.COL_USER_LNAME, user.getUserLastName());
        values.put(DbTable.COL_USER_PHONE, user.getUserPhone());
        values.put(DbTable.COL_USER_EMAIL, user.getUserEmail());
        values.put(DbTable.COL_USER_PASSWORD, user.getUserPassword());
        return mDbHelper.updateData(DbTable.TABLE_USER, values, email);
    }

    public boolean checkUserCredentials(String email, String password){
        return mDbHelper.checkUser(email, password);
    }

    public Member getUserDetails(String email){
        return mDbHelper.getUserDetail(email);
    }

    public boolean deleteAccount(String email){
        return mDbHelper.deleteUser(email);
    }
}
