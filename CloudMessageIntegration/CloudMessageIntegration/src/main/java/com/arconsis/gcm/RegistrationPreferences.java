package com.arconsis.gcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by alexfrank on 24.05.13.
 */
public class RegistrationPreferences {
    public static final String REGISTRATION_ID = "registrationId";
    private Context context;

    public RegistrationPreferences(Context context) {
        this.context = context;
    }

    public void setRegistrationId(String id){
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(REGISTRATION_ID, id);
        edit.commit();
    }

    public String getRegistrationId(){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(REGISTRATION_ID, "");
    }

    public boolean isRegistered(){
        return !"".equals(getRegistrationId());
    }
}
