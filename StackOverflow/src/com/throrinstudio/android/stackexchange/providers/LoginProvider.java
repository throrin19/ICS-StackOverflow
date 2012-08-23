package com.throrinstudio.android.stackexchange.providers;

import android.net.Uri;

import com.throrinstudio.android.common.providers.BasicProvider;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.utils.StackExchangeApiUtils;

public class LoginProvider extends BasicProvider{


	public Uri getRegistrationUrl(){
		return Uri.parse("http://stackoverflow.com/users/login#create-account");
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
}