package com.throrinstudio.android.stackoverflow.modules.login;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.throrinstudio.android.stackoverflow.R;
import com.throrinstudio.android.stackoverflow.libs.social.stackoverflow.StackOverflowDialog;
import com.throrinstudio.android.stackoverflow.libs.social.stackoverflow.StackOverflowDialog.SoDialogListener;
import com.throrinstudio.android.stackoverflow.modules.basic.AbstractBasicFragment;
import com.throrinstudio.android.stackoverflow.modules.basic.AbstractBasicModel;
import com.throrinstudio.android.stackoverflow.providers.LoginProvider;

public class LoginFragment extends AbstractBasicFragment{

	private Button registerButton;
	private Button LoginButton;
	
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
				Intent i = new Intent(Intent.ACTION_VIEW, ((LoginProvider)mModel.getProvider()).getRegistrationUrl());
				startActivity(i);
			}
		});
		
		LoginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StackOverflowDialog d = StackOverflowDialog.newInstance(getActivity(), ((LoginProvider)mModel.getProvider()).getOauthUrl(), new SoDialogListener() {
					
					@Override
					public void onError(String value) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onComplete(String value) {
						// TODO Auto-generated method stub
						
					}
				});
				
				d.show(getFragmentManager(), "SoDialog");
			}
		});
	}

	@Override
	protected void bindViews(View v) {
		registerButton = (Button) v.findViewById(R.id.register);
		LoginButton = (Button) v.findViewById(R.id.login);
	}

	

}
