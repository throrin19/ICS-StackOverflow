package com.throrinstudio.android.stackoverflow;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

public class Application  extends android.app.Application{
	
	/**
     * Contexte of the application.
     */
    private static Context CONTEXT;
    /**
     * true if Log is enable, false otherwise
     */
    private static final boolean LOG = true;
    
    
    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this;

        //Thread.setDefaultUncaughtExceptionHandler(new GoomeoExceptionHandler());
    }
    
    /**
     * Retrieve application context
     *
     * @return Context
     */
    public static Context getContext() {
        return CONTEXT;
    }
    
    public static String getApplicationPackageName() {
        return CONTEXT.getApplicationInfo().packageName;
    }
    
    /**
     * Retourne les préférences propres à l'application avec un niveau de
     * sécurité privée
     *
     * @return {@link SharedPreferences} les préférences
     */
    public static SharedPreferences getPreferences() {
        return CONTEXT.getSharedPreferences(getApplicationPackageName(),
                MODE_PRIVATE);
    }
    
    /**
     * Check is the log is Enable or Not
     *
     * @return true if log enable, false otherwise
     */
    public static boolean isLog() {
        return LOG;
    }
    
    public static Resources getRessources() {
        return CONTEXT.getResources();
    }

    public static int getRessourceByName(String name) {
        return CONTEXT.getResources().getIdentifier(name, "drawable",
                Application.getApplicationPackageName());
    }
    
    /**
     * Get String from a given resource id
     *
     * @param resId resource id
     * @return String
     */
    public static String getAppString(int resId) {
        return CONTEXT.getString(resId);
    }

}
