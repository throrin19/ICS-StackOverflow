package com.throrinstudio.android.stackexchange.libs.social.stackexchange;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.throrinstudio.android.common.utils.MeasuresUtils;
import com.throrinstudio.android.stackexchange.R;

public class StackExchangeDialog extends DialogFragment{
	

    static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                         						ViewGroup.LayoutParams.FILL_PARENT);
    
    static final String DEFAULT_CALLBACK = "https://stackexchange.com/oauth/login_success";
    
    static final int MARGIN = 4;
    static final int PADDING = 2;
    
    private Context				mContext;
    private String 				mUrl;
    private SeDialogListener 	mListener;
    private ProgressDialog 		mSpinner;
    private WebView 			mWebView;
    private LinearLayout 		mContent;
    private TextView 			mTitle;
    
    private String				mCallback;

    private static final String TAG = "StackOverflow-WebView";
    
    private StackExchangeDialog(Context context, String url, SeDialogListener listener) {
        mUrl 		= url;
        mListener 	= listener;
        mContext	= context;
        mCallback 	= DEFAULT_CALLBACK;
    };
    
    private Context getContext(){
    	return mContext;
    }
    
    public static StackExchangeDialog newInstance(Context c, String url, SeDialogListener l){
    	return new StackExchangeDialog(c, url, l);
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	Dialog d = new Dialog(mContext);
    	
    	mSpinner = new ProgressDialog(getContext());
        
        mSpinner.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mSpinner.setMessage(getContext().getString(R.string.global_loading)+"...");
        mSpinner.setCanceledOnTouchOutside(false);

        mContent = new LinearLayout(getContext());
        mContent.setOrientation(LinearLayout.VERTICAL);
        
        setUpTitle(d);
        setUpWebView();
        
        Display display 	= d.getWindow().getWindowManager().getDefaultDisplay();
        
        d.setCanceledOnTouchOutside(false);
        
        if(display.getWidth() > MeasuresUtils.DpToPx(600)){
        	if(display.getWidth() < display.getHeight()){
        		d.addContentView(mContent, new FrameLayout.LayoutParams(display.getWidth(),
        				display.getHeight()/2));
        	}else{
        		d.addContentView(mContent, new FrameLayout.LayoutParams(display.getWidth()/2,
        				display.getHeight()));
        	}
        }else{
        	d.addContentView(mContent, new FrameLayout.LayoutParams(display.getWidth(),
    				display.getHeight()));
        }
        
        
        return d;
    }
    
    public void setCallbackUrl(String callback){
    	mCallback = callback;
    }
    
    
    private void setUpTitle(Dialog d) {
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        Drawable icon = getContext().getResources().getDrawable(R.drawable.ic_dialog_web);
        
        mTitle = new TextView(getContext());
        
        mTitle.setText(getContext().getString(R.string.app_name));
        mTitle.setTextColor(Color.WHITE);
        mTitle.setTypeface(Typeface.DEFAULT_BOLD);
        mTitle.setBackgroundColor(0xFF3CBDEC);
        mTitle.setPadding(MARGIN + PADDING, MARGIN, MARGIN, MARGIN);
        mTitle.setCompoundDrawablePadding(MARGIN + PADDING);
        mTitle.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
        
        mContent.addView(mTitle);
    }

    @SuppressLint("SetJavaScriptEnabled")
	private void setUpWebView() {
        mWebView = new WebView(getContext());
        android.webkit.CookieManager.getInstance().removeAllCookie();
        android.webkit.CookieManager.getInstance().removeSessionCookie();
        
        
        mWebView.clearHistory();
		mWebView.clearFormData();
		mWebView.clearCache(true);
		
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setWebViewClient(new StackWebViewClient());
        
        WebSettings settings = mWebView.getSettings();
		settings.setSavePassword			(false);
		settings.setSaveFormData			(false);
		settings.setJavaScriptEnabled		(true);
		settings.setSupportZoom				(false);
		settings.setCacheMode				(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		settings.setDomStorageEnabled		(true);
		settings.setSupportMultipleWindows	(false);
		settings.setAppCacheEnabled			(false);
		
        mWebView.loadUrl(mUrl);
        mWebView.setLayoutParams(FILL);
        
        mContent.addView(mWebView);
    }

    private class StackWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        	Log.d(TAG, "Redirecting URL " + url);
        	
        	
        	if (url.startsWith(mCallback)) {
        		android.webkit.CookieManager.getInstance().removeAllCookie();
        		
        		Log.d(TAG, "CallBack");
        		
        		Uri response = Uri.parse(url);
        		
        		String token = response.getEncodedFragment();
        		
        		if(token.startsWith("access_token=")){
        			mListener.onComplete(token.replace("access_token=", ""));
        		}else{
        			mListener.onError(mContext.getString(R.string.login_error));
        		}
        		
        		mWebView.destroy();
        		mWebView = null;
        		
        		StackExchangeDialog.this.dismiss();   
        		
        		return true;
        	}
        	
            return false;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

        	
            super.onReceivedError(view, errorCode, description, failingUrl);
      
            mListener.onError(description);
            
            StackExchangeDialog.this.dismiss();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mSpinner.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mSpinner.dismiss();
        }

    }
    
    
    public interface SeDialogListener {
		public void onComplete(String value);
	
		public void onError(String value);
	}
}
