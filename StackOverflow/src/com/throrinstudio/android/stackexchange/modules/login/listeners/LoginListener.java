package com.throrinstudio.android.stackexchange.modules.login.listeners;

import android.app.Activity;

import com.throrinstudio.android.common.utils.LogManager;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApp.AuthorizeListener;

public class LoginListener implements AuthorizeListener{

	private Activity mActivity;
	
	public LoginListener(Activity a){
		mActivity = a;
	}
	
	@Override
	public void onSuccess(String value) {
		LogManager.logInformation("success");
		LogManager.logInformation(value);
	}

	@Override
	public void onError(String value) {
		LogManager.logInformation("error");
		LogManager.logInformation(value);
	}
}
