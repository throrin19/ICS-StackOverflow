package com.throrinstudio.android.stackexchange.providers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.throrinstudio.android.common.providers.BasicProvider;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi.RequestListener;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApp;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.User;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.utils.StackExchangeApiUtils;
import com.throrinstudio.android.stackexchange.modules.login.LoginFragment;
import com.throrinstudio.android.stackexchange.modules.login.listeners.LoginListener;

public class LoginProvider extends BasicProvider{
	
	public static final String PREFERENCES_ACCOUNT  = "preferences_account";
	
	public static final String KEY_ACCOUNT_TOKEN  	= "stack_account_accesstoken";
	public static final String KEY_ACCOUNT_LOGIN	= "stack_account_login";
	public static final String KEY_ACCOUNT_PICTURE	= "stack_account_picture";
	public static final String KEY_ACCOUNT_EMAIL	= "stack_account_email";
	
	public static SharedPreferences getAccountPreferences(Context ctx){
		SharedPreferences preferences = ctx.getSharedPreferences(PREFERENCES_ACCOUNT, Context.MODE_PRIVATE);
		return preferences;
	}
	
	public String getOauthUrl(){
		return StackExchangeApiUtils.getOauthUrl();
	}
	
	public String getClientId(){
		return StackExchangeApiUtils.getAppId();
	}
	
	public String getRedirectUri(){
		return StackExchangeApiUtils.getRedirectUrl();
	}
	
	
	public void login(LoginFragment f){
		LoginListener listener 	= new LoginListener(f);
		
		StackExchangeApp stackApp = new StackExchangeApp(f.getActivity(), StackExchangeApiUtils.getOauthUrl(), StackExchangeApiUtils.getAppId());
	 	stackApp.setRedirectUrl(StackExchangeApiUtils.getRedirectUrl());
	 	stackApp.setScopes(StackExchangeApp.SCOPE_NO_EXPIRY+","+StackExchangeApp.SCOPE_WRITE_ACCESS);
	 	stackApp.authorize(listener);
	}
	
	public boolean hasAccessToken(Context ctx){
		return getAccountPreferences(ctx).getString(KEY_ACCOUNT_TOKEN, "").length() > 0;
	}
	
	public String getAccessToken(Context ctx){
		return getAccountPreferences(ctx).getString(KEY_ACCOUNT_TOKEN, "");
	}
	
	public boolean hasAccountInfos(Context ctx){
		return getAccountPreferences(ctx).getString(KEY_ACCOUNT_LOGIN, "").length() > 0;
	}
	
	public void showSites(Context ctx, RequestListener listener){
		StackExchangeApi api = new StackExchangeApi();
		api.getSitesList(ctx, listener);
	}
	
	public User getAccountInfos(Context ctx){
		User user 				= new User();
		SharedPreferences prefs = getAccountPreferences(ctx);
		
		user.setDisplay_name(prefs.getString(KEY_ACCOUNT_LOGIN, ""));
		user.setProfile_image(prefs.getString(KEY_ACCOUNT_PICTURE, ""));
		
		return user;
	}
	
	public void loadUser(Context ctx, RequestListener listener){
		StackExchangeApi api = new StackExchangeApi();
		api.getUser(ctx, getAccessToken(ctx), "stackoverflow", listener);
	}
	
	public void saveUserInfos(Context ctx, User user){
		SharedPreferences prefs = getAccountPreferences(ctx);
		Editor edit = prefs.edit();
		edit.putString(KEY_ACCOUNT_LOGIN, user.getDisplay_name());
		edit.putString(KEY_ACCOUNT_PICTURE, user.getProfile_image());
		edit.commit();
	}
}