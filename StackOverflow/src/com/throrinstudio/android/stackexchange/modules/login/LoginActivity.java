package com.throrinstudio.android.stackexchange.modules.login;

import com.throrinstudio.android.common.modules.basic.AbstractBasicActivity;
import com.throrinstudio.android.common.modules.basic.AbstractBasicFragment;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicActivity;

public class LoginActivity extends AbstractStackBasicActivity{

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
