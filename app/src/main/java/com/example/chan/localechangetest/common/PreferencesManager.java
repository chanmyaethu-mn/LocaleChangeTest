package com.example.chan.localechangetest.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.chan.localechangetest.common.Constants;

/**
 * Created by techfun on 1/31/2018.
 */

public final class PreferencesManager {
    private static final String PREFERENCE_NAME = "LOCALE_CHANGE_TEST";

    private static SharedPreferences getSharedPreferences(Context mContext) {
        return mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static void saveLanguage(@NonNull Context context,@NonNull String languageCode) {
        SharedPreferences.Editor mEditor = getSharedPreferences(context).edit();
        mEditor.putString(Constants.LANGUAGE_CODE, languageCode);
        mEditor.apply();
    }

    public static String getActiveLanguange(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(Constants.LANGUAGE_CODE, null);
    }
}
