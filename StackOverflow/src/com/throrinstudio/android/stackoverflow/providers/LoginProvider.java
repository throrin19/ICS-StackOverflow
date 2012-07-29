package com.throrinstudio.android.stackoverflow.providers;

import android.net.Uri;

import com.throrinstudio.android.stackoverflow.utils.api.AbstractApiUtils;
import com.throrinstudio.android.stackoverflow.utils.api.StackoverflowApiUtils;

public class LoginProvider extends BasicProvider{


	public Uri getRegistrationUrl(){
		return Uri.parse("http://stackoverflow.com/users/login#create-account");
	}
	
	
	public String getOauthUrl(){
		return new StackoverflowApiUtils().getOauthUrl();
	}
	
	public String getClientId(){
		return new StackoverflowApiUtils().getAppId();
	}
	
	public String getRedirectUri(){
		return "https://stackexchange.com/oauth/login_success";
	}
}