package com.throrinstudio.android.stackexchange.providers;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;

import com.throrinstudio.android.common.libs.widgets.dialogs.CustomDialog;
import com.throrinstudio.android.common.libs.widgets.dialogs.LoadingDialog;
import com.throrinstudio.android.common.providers.BasicProvider;
import com.throrinstudio.android.common.utils.LogManager;
import com.throrinstudio.android.stackexchange.R;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApi.RequestListener;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeApp;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.StackExchangeError;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.utils.StackExchangeApiUtils;
import com.throrinstudio.android.stackexchange.modules.login.adapters.SitesAdapter;
import com.throrinstudio.android.stackexchange.modules.login.listeners.LoginListener;

public class LoginProvider extends BasicProvider{

	private SitesAdapter mSitesAdapter;
	private Activity mActivity;
	
	public String getOauthUrl(){
		return StackExchangeApiUtils.getOauthUrl();
	}
	
	public String getClientId(){
		return StackExchangeApiUtils.getAppId();
	}
	
	public String getRedirectUri(){
		return StackExchangeApiUtils.getRedirectUrl();
	}
	
	
	public void showSitesList(final LoadingDialog loadingDialog, final Activity ctx){
		
		mActivity 							 = ctx;
		RequestListener sitesRequestListener = new RequestListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onComplete(Object state) {
				LogManager.logInformation("Liste de sites bien récupérée");
				
				if(loadingDialog != null)
					loadingDialog.dismiss();
				
				showSiteListTask((List<Site>) state, ctx);
			}
			
			@Override
			public void onIOException(IOException e, Object state) {
				if(loadingDialog != null)
					loadingDialog.dismiss();
			}
			
			@Override
			public void onError(StackExchangeError e, Object state) {
				if(loadingDialog != null)
					loadingDialog.dismiss();
			}
		};
		
		
		StackExchangeApi api = new StackExchangeApi();
		api.getSitesList(ctx, sitesRequestListener);
		
		
	}

	public void saveAuthenticatedUser(String accessToken, Site site){
		// création RequestListener + sauvegarde en base si user existe pour le site et alerte crouton sinon)
	}
	
	private void showSiteListTask(List<Site> sites, Activity ctx){
		
		mSitesAdapter = new SitesAdapter(ctx, sites);
		CustomDialog dialog = CustomDialog.newInstance(ctx, ctx.getString(R.string.login_site), mSitesAdapter, mSitesActionListener);
		dialog.show(ctx.getFragmentManager(), "choiceSites");
	}
	
	private DialogInterface.OnClickListener mSitesActionListener = new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int pos) {
			Site site 				= mSitesAdapter.getItem(pos);
			LoginListener listener 	= new LoginListener(mActivity, site);
			
			StackExchangeApp stackApp = new StackExchangeApp(mActivity, StackExchangeApiUtils.getOauthUrl(), StackExchangeApiUtils.getAppId());
		 	stackApp.setRedirectUrl(StackExchangeApiUtils.getRedirectUrl());
		 	stackApp.setScopes(StackExchangeApp.SCOPE_NO_EXPIRY+","+StackExchangeApp.SCOPE_WRITE_ACCESS);
		 	stackApp.authorize(listener);
		}
	};
}