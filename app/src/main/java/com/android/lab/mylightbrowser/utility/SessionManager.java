package com.android.lab.mylightbrowser.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Shivichu on 05-09-2017.
 */

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "SessionManager";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_EMAIL = "useremail";
    private static final String KEY_NAME = "name";
    private static final String KEY_ID = "id";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public void setLoginData(String userEmail, String username, int id) {
        editor.putString(KEY_EMAIL, userEmail);
        editor.putString(KEY_NAME, username);
        editor.putInt(KEY_ID, id);

        editor.commit();

    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void logoutUser() {

        editor.clear();
        editor.commit();
    }

}