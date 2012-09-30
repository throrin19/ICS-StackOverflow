package com.throrinstudio.android.stackexchange.providers;

import android.app.Activity;

import com.throrinstudio.android.common.providers.BasicProvider;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApp;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.utils.StackExchangeApiUtils;
import com.throrinstudio.android.stackexchange.modules.login.listeners.LoginListener;

public class LoginProvider extends BasicProvider{
	
	public String getOauthUrl(){
		return StackExchangeApiUtils.getOauthUrl();
	}
	
	public String getClientId(){
		return StackExchangeApiUtils.getAppId();
	}
	
	public String getRedirectUri(){
		return StackExchangeApiUtils.getRedirectUrl();
	}
	
	
	public void login(Activity a){
		LoginListener listener 	= new LoginListener(a);
		
		StackExchangeApp stackApp = new StackExchangeApp(a, StackExchangeApiUtils.getOauthUrl(), StackExchangeApiUtils.getAppId());
	 	stackApp.setRedirectUrl(StackExchangeApiUtils.getRedirectUrl());
	 	stackApp.setScopes(StackExchangeApp.SCOPE_NO_EXPIRY+","+StackExchangeApp.SCOPE_WRITE_ACCESS);
	 	stackApp.authorize(listener);
	}
}