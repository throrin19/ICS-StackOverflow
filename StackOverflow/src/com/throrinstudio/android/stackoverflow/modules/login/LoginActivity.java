package com.throrinstudio.android.stackoverflow.modules.login;

import com.throrinstudio.android.stackoverflow.modules.basic.AbstractBasicActivity;
import com.throrinstudio.android.stackoverflow.modules.basic.AbstractBasicFragment;

public class LoginActivity extends AbstractBasicActivity{

	@Override
	protected AbstractBasicFragment getFragment() {
		// TODO Auto-generated method stub
		return new LoginFragment();
	}

	@Override
	protected String getFragmentTag() {
		// TODO Auto-generated method stub
		return null;
	}

}
