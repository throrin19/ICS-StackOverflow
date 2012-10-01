package com.throrinstudio.android.stackexchange.modules.login;

import com.throrinstudio.android.common.modules.basic.AbstractBasicFragment;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicActivity;

public class LoginActivity extends AbstractStackBasicActivity{

	private static final long serialVersionUID = 2419071721203214716L;

	@Override
	protected AbstractBasicFragment getFragment() {
		// TODO Auto-generated method stub
		return LoginFragment.newInstance();
	}

	@Override
	protected String getFragmentTag() {
		// TODO Auto-generated method stub
		return null;
	}

}
