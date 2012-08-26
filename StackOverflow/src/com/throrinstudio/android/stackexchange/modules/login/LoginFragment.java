package com.throrinstudio.android.stackexchange.modules.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.throrinstudio.android.common.libs.widgets.dialogs.LoadingDialog;
import com.throrinstudio.android.common.modules.basic.AbstractBasicModel;
import com.throrinstudio.android.stackexchange.R;
import com.throrinstudio.android.stackexchange.modules.basic.AbstractStackBasicFragment;
import com.throrinstudio.android.stackexchange.providers.LoginProvider;

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
		
		((LoginProvider)mModel.getProvider()).showSitesList(mLoadingDialog, getActivity());
	}
	
	
}
