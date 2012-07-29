package com.throrinstudio.android.stackoverflow.libs.social.stackoverflow;

import java.net.URL;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.throrinstudio.android.stackoverflow.Application;

public class StackOverflowSession {

	private SharedPreferences sharedPref;
	private Editor editor;
	
	private static final String STACK_AUTH_KEY = "stack_auth_key";
	private static final String STACK_AUTH_SECRET_KEY = "stack_auth_secret_key";
	private static final String STACK_USER_NAME = "stack_user_name";
	
	public StackOverflowSession(Context context) {
		sharedPref 	  = Application.getPreferences();
		editor 		  = sharedPref.edit();
	}
	
	/*public void storeAccessToken(AccessToken accessToken, String username, URL profileImage) {
		editor.putString(STACK_AUTH_KEY, accessToken.getToken());
		editor.putString(STACK_AUTH_SECRET_KEY, accessToken.getTokenSecret());
		editor.putString(STACK_USER_NAME, username);
		editor.commit();
	}
	
	public void resetAccessToken() {
		editor.putString(STACK_AUTH_KEY, null);
		editor.putString(STACK_AUTH_SECRET_KEY, null);
		editor.putString(STACK_USER_NAME, null);
		editor.commit();
	}
	
	public String getUsername() {
		return sharedPref.getString(STACK_USER_NAME, "");
	}
	
	public AccessToken getAccessToken() {
		String token 		= sharedPref.getString(STACK_AUTH_KEY, null);
		String tokenSecret 	= sharedPref.getString(STACK_AUTH_SECRET_KEY, null);
		
		if (token != null && tokenSecret != null) 
			return new AccessToken(token, tokenSecret);
		else
			return null;
	}*/
}
