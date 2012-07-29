package com.throrinstudio.android.stackoverflow.libs.social.stackoverflow;

import java.io.IOException;

import android.app.Activity;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.Message;

public class StackOverflowApp {

	private Activity mActivity;
	private String mClientId;
	private String mScopes;
	private String mRedirect;
	private String mUrl;
	
	public static final String SCOPE_READ_INBOX		= "read_inbox";
	public static final String SCOPE_NO_EXPIRY 		= "no_expiry";
	public static final String SCOPE_WRITE_ACCESS 	= "write_access";
	public static final String SCOPE_PRIVATE_INFO	= "private_info";
	
	private static final String PARAM_CLIENT_ID 	= "client_id";
	private static final String PARAM_SCOPE 		= "scope";
	private static final String PARAM_REDIRECT 		= "redirect_uri";
	private static final String PARAM_STATE 		= "state";
	
	public StackOverflowApp(Activity a, String signUrl, String clientId){
		mActivity 		= a;
		mClientId 		= clientId;
		mUrl			= signUrl;
	}
	
	public void setScopes(String scopes){
		mScopes = scopes;
	}
	
	public void setRedirectUrl(String url){
		mRedirect = url;
	}
	
	public void authorize(){
		// Fonction qui va appeler notre dialog si utile
		try {
			validParams();
			
			Uri uri = Uri.parse(mUrl);
			final Builder b = uri.buildUpon();
			b.appendQueryParameter(PARAM_CLIENT_ID, mClientId);
			if(mScopes != null && mScopes.length() > 0){
				b.appendQueryParameter(PARAM_SCOPE, mScopes);
			}
			if(mRedirect != null && mRedirect.length() > 0){
				b.appendQueryParameter(PARAM_REDIRECT, mRedirect);
			}
			
			/*new Thread() {
				@Override
				public void run() {
					String url = b.toString();
					
					
					
				}
			}.start();*/
			
			StackOverflowDialog.newInstance(mActivity, b.toString(), null).show(mActivity.getFragmentManager(), "StackDialog");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void validParams() throws IOException{
		if(mClientId == null || mClientId.length() == 0){
			throw new IOException("client_id must be not null");
		}
	}
	
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			
			
		}
	};
}
