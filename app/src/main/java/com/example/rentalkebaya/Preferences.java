package com.example.rentalkebaya;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    /** Pendlakarasian Shared Preferences yang berdasarkan paramater context */
    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void clearAll(Context context) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.clear();
        editor.commit();
    }
}
