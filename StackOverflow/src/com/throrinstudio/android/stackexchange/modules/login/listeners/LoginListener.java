package com.throrinstudio.android.stackexchange.modules.login.listeners;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.throrinstudio.android.common.utils.LogManager;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApp.AuthorizeListener;
import com.throrinstudio.android.stackexchange.modules.login.LoginFragment;
import com.throrinstudio.android.stackexchange.providers.LoginProvider;

import de.neofonie.mobile.app.android.widget.crouton.Crouton;
import de.neofonie.mobile.app.android.widget.crouton.Style;

public class LoginListener implements AuthorizeListener{

	private LoginFragment 	mFragment;
	
	public LoginListener(LoginFragment f){
		mFragment = f;
	}
	
	@Override
	public void onSuccess(String token) {
		LogManager.logInformation("token récupéré");
		
//		SharedPreferences preferences = LoginProvider.getAccountPreferences(mFragment.getActivity().getApplicationContext());
//		Editor editor = preferences.edit();
//		editor.putString(LoginProvider.KEY_ACCOUNT_TOKEN, token);
//		editor.commit();
	}

	@Override
	public void onError(String value) {
		Crouton.makeText(mFragment.getActivity(), value, Style.ALERT).show();
	}
}
