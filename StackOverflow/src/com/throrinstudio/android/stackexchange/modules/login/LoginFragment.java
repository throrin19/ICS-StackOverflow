package com.throrinstudio.android.stackexchange.modules.login;

import java.io.IOException;
import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.throrinstudio.android.common.modules.basic.AbstractBasicModel;
import com.throrinstudio.android.stackexchange.R;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi.RequestListener;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeError;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicFragment;
import com.throrinstudio.android.stackexchange.modules.login.adapters.SitesAdapter;
import com.throrinstudio.android.stackexchange.providers.LoginProvider;

import de.neofonie.mobile.app.android.widget.crouton.Crouton;
import de.neofonie.mobile.app.android.widget.crouton.Style;

public class LoginFragment extends AbstractStackBasicFragment{

	private Button  		mAddButton;
	private ListView 		mListView;
	
	
	public LoginFragment(){
		super();
	}
	
	public static LoginFragment newInstance(){
		return new LoginFragment();
	}
	
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
		mAddButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((LoginProvider)mModel.getProvider()).login(LoginFragment.this);
			}
		});
	}

	@Override
	protected void bindViews(View v) {
		mAddButton 		= (Button) v.findViewById(R.id.register);
		mListView 		= (ListView) v.findViewById(R.id.sites_list);
		
	}
	
	public void loadSites(){
		RequestListener listener = new RequestListener() {
			@Override
			public void onIOException(IOException e, Object state) {
				Crouton.makeText(getActivity(), e.getMessage(), Style.ALERT);
			}
			
			@Override
			public void onError(StackExchangeError e, Object state) {
				Crouton.makeText(getActivity(), e.getMessage(), Style.ALERT);
			}
			
			@Override
			public void onComplete(Object state) {
				SitesAdapter adapter = new SitesAdapter(getActivity(), (List<Site>) state);
				mListView.setAdapter(adapter);
			}
		};
		((LoginProvider)mModel.getProvider()).showSites(getActivity().getApplicationContext(), listener);
	}

	@Override
	public void onResume() {
		super.onResume();
		
		loadSites();
	}
	
}
