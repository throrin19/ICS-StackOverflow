package com.throrinstudio.android.stackexchange.modules.login;

import java.io.IOException;
import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.widgets.lazylist.ImageLoader;
import com.throrinstudio.android.common.modules.basic.AbstractBasicModel;
import com.throrinstudio.android.stackexchange.R;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi.RequestListener;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeError;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.User;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicFragment;
import com.throrinstudio.android.stackexchange.modules.login.adapters.SitesAdapter;
import com.throrinstudio.android.stackexchange.providers.LoginProvider;

import de.neofonie.mobile.app.android.widget.crouton.Crouton;
import de.neofonie.mobile.app.android.widget.crouton.Style;

public class LoginFragment extends AbstractStackBasicFragment{

	private Button  		mAddButton;
	private ListView 		mListView;
	private LinearLayout 	mPanel;
	private LinearLayout 	mLoading;
	private LinearLayout	mUserInfos;
	private ImageView 		mUserPicture;
	private TextView		mUserName;
	
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
		mPanel			= (LinearLayout) v.findViewById(R.id.siteList);
		mLoading		= (LinearLayout) v.findViewById(R.id.loading);
		mUserInfos		= (LinearLayout) v.findViewById(R.id.account_infos);
		mUserPicture	= (ImageView) v.findViewById(R.id.account_picture);
		mUserName		= (TextView) v.findViewById(R.id.account_login);
	}
	
	public void loadSites(){
		mPanel.setVisibility(View.GONE);
		mLoading.setVisibility(View.VISIBLE);
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
				
				mPanel.setVisibility(View.VISIBLE);
				mLoading.setVisibility(View.GONE);
			}
		};
		((LoginProvider)mModel.getProvider()).showSites(getActivity().getApplicationContext(), listener);
	}
	
	public void loadUser(){
		// On test si le user existe seulement si on a un token
		// S'il existe, on l'affiche, sinon on effectue la requète pour l'afficher
		if(((LoginProvider)mModel.getProvider()).hasAccessToken(getActivity())){
			mAddButton.setVisibility(View.GONE);
			mUserInfos.setVisibility(View.VISIBLE);
			
			if(((LoginProvider)mModel.getProvider()).hasAccountInfos(getActivity())){
				showUser(((LoginProvider)mModel.getProvider()).getAccountInfos(getActivity()));
			}else{
				((LoginProvider)mModel.getProvider()).loadUser(getActivity(), new RequestListener() {
					
					@Override
					public void onIOException(IOException e, Object state) {
						Crouton.makeText(getActivity(), e.getMessage(), Style.ALERT).show();
						mAddButton.setVisibility(View.VISIBLE);
						mUserInfos.setVisibility(View.GONE);
					}
					
					@Override
					public void onError(StackExchangeError e, Object state) {
						Crouton.makeText(getActivity(), e.getMessage(), Style.ALERT).show();
						mAddButton.setVisibility(View.VISIBLE);
						mUserInfos.setVisibility(View.GONE);
					}
					
					@Override
					public void onComplete(Object state) {
						((LoginProvider)mModel.getProvider()).saveUserInfos(getActivity(), (User) state);
						showUser((User) state);
					}
				});
			}
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		
		loadSites();
		loadUser();
	}
	
	private void showUser(User user){
		mUserName.setText(user.getDisplay_name());
		ImageLoader loader = new ImageLoader(getActivity());
		mUserPicture.setTag(user.getProfile_image());
		loader.DisplayImage(user.getProfile_image(), mUserPicture);
	}
	
}
