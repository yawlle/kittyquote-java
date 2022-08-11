package com.yawlle.kittyquotesjava.infra;

import android.content.SharedPreferences;

public class SecurityPreferences {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SecurityPreferences (SharedPreferences preferences){
        this.preferences = preferences;
        this.editor = this.preferences.edit();
    }

    public void saveNameString(String key, String value){
        this.editor.putString(key,value);
        this.editor.commit();
    }

    public String getNomeString(String key) {
            return this.preferences.getString(key,"");
    }
}
