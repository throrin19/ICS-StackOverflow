package com.throrinstudio.android.stackexchange.modules.login;

import java.io.IOException;
import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.throrinstudio.android.common.libs.widgets.dialogs.LoadingDialog;
import com.throrinstudio.android.common.modules.basic.AbstractBasicModel;
import com.throrinstudio.android.stackexchange.R;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi.RequestListener;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeError;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicFragment;

public class LoginFragment extends AbstractStackBasicFragment{

	private Button  		mAddButton;
	private ListView 		mListAccounts;
	private View			mEmptyView;
	private LoadingDialog	mLoadingDialog;
	
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
				showListSites();
			}
		});
	}

	@Override
	protected void bindViews(View v) {
		mAddButton 		= (Button) v.findViewById(R.id.register);
		mListAccounts 	= (ListView) v.findViewById(R.id.accounts_list);
		mEmptyView		= v.findViewById(R.id.accounts_empty);
	}

	

	private void showListSites(){
		
		mLoadingDialog = LoadingDialog.newInstance("Chargement", "Veillez patienter...");
		mLoadingDialog.show(getFragmentManager(), "loading");
		
		StackExchangeApi api = new StackExchangeApi();
		api.getSitesList(getActivity(), mSitesRequestListener);
	}
	
	private RequestListener mSitesRequestListener = new RequestListener() {
		
		@Override
		public void onComplete(Object state) {
			List<Site> sites = (List<Site>) state;
			
			if(mLoadingDialog != null)
				mLoadingDialog.dismiss();
		}
		
		@Override
		public void onIOException(IOException e, Object state) {
			if(mLoadingDialog != null)
				mLoadingDialog.dismiss();
		}
		
		@Override
		public void onError(StackExchangeError e, Object state) {
			if(mLoadingDialog != null)
				mLoadingDialog.dismiss();
		}
	};
}
