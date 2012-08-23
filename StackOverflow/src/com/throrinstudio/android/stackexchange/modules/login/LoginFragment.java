package com.throrinstudio.android.stackexchange.modules.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.throrinstudio.android.common.modules.basic.AbstractBasicModel;
import com.throrinstudio.android.stackexchange.R;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackOverflowApp;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicFragment;
import com.throrinstudio.android.stackexchange.providers.LoginProvider;

public class LoginFragment extends AbstractStackBasicFragment{

	private Button registerButton;
	
	@Override
	public int getFragmentLayoutResource() {
		return R.layout.module_login;
	}
	
	@Override
	public AbstractBasicModel initModel() {
		return new LoginModel();
	}
	
	@Override
	protected void initViews() {
		registerButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StackOverflowApp stackApp = new StackOverflowApp(getActivity(), ((LoginProvider)mModel.getProvider()).getOauthUrl(), ((LoginProvider)mModel.getProvider()).getClientId());
				stackApp.setRedirectUrl(((LoginProvider)mModel.getProvider()).getRedirectUri());
				stackApp.setScopes(StackOverflowApp.SCOPE_NO_EXPIRY+","+StackOverflowApp.SCOPE_WRITE_ACCESS);
				stackApp.authorize();
			}
		});
	}

	@Override
	protected void bindViews(View v) {
		registerButton = (Button) v.findViewById(R.id.register);
	}

	

}
