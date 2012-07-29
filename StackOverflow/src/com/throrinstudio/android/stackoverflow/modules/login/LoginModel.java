package com.throrinstudio.android.stackoverflow.modules.login;

import com.throrinstudio.android.stackoverflow.modules.basic.AbstractBasicModel;
import com.throrinstudio.android.stackoverflow.providers.BasicProvider;
import com.throrinstudio.android.stackoverflow.providers.LoginProvider;

public class LoginModel extends AbstractBasicModel{

	@Override
	public BasicProvider initProvider() {
		return new LoginProvider();
	}

	@Override
	public BasicProvider getProvider() {
		// TODO Auto-generated method stub
		return mProvider;
	}

}
