package com.throrinstudio.android.stackexchange.modules.login;

import com.throrinstudio.android.common.providers.BasicProvider;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicModel;
import com.throrinstudio.android.stackexchange.providers.LoginProvider;

public class LoginModel extends AbstractStackBasicModel{

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
