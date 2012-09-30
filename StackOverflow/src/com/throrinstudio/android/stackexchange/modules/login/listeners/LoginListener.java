package com.throrinstudio.android.stackexchange.modules.login.listeners;

import android.app.Activity;

import com.throrinstudio.android.common.utils.LogManager;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApp.AuthorizeListener;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;

import de.neofonie.mobile.app.android.widget.crouton.Crouton;
import de.neofonie.mobile.app.android.widget.crouton.Style;

public class LoginListener implements AuthorizeListener{

	private Activity 	mActivity;
	
	public LoginListener(Activity a){
		mActivity = a;
	}
	
	@Override
	public void onSuccess(String token) {
		LogManager.logInformation("token = "+token);
		
	}

	@Override
	public void onError(String value) {
		Crouton.makeText(mActivity, value, Style.ALERT).show();
	}
}
