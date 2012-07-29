package com.throrinstudio.android.stackoverflow.libs.social.stackoverflow;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.throrinstudio.android.stackoverflow.R;

public class StackOverflowDialog extends DialogFragment{
	
	static final float[] DIMENSIONS_LANDSCAPE = {460, 260};
    static final float[] DIMENSIONS_PORTRAIT = {280, 420};
    static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                         						ViewGroup.LayoutParams.FILL_PARENT);
    static final int MARGIN = 4;
    static final int PADDING = 2;
    
    private Context				mContext;
    private String 				mUrl;
    private SoDialogListener 	mListener;
    private ProgressDialog 		mSpinner;
    private WebView 			mWebView;
    private LinearLayout 		mContent;
    private TextView 			mTitle;

    private static final String TAG = "Twitter-WebView";
	

    private StackOverflowDialog(Context context, String url, SoDialogListener listener) {
        super();
        
        mUrl 		= url;
        mListener 	= listener;
        mContext	= context;
    };
    
    private Context getContext(){
    	return mContext;
    }
    
    public static StackOverflowDialog newInstance(Context c, String url, SoDialogListener l){
    	return new StackOverflowDialog(c, url, l);
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	Dialog d = new Dialog(mContext);
    	
    	mSpinner = new ProgressDialog(getContext());
        
        mSpinner.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mSpinner.setMessage(getContext().getString(R.string.global_loading)+"...");

        mContent = new LinearLayout(getContext());
        mContent.setOrientation(LinearLayout.VERTICAL);
        
        setUpTitle(d);
        setUpWebView();
        
        Display display 	= d.getWindow().getWindowManager().getDefaultDisplay();
        final float scale 	= getContext().getResources().getDisplayMetrics().density;
        float[] dimensions 	= (display.getWidth() < display.getHeight()) ? DIMENSIONS_PORTRAIT : DIMENSIONS_LANDSCAPE;
        
        d.addContentView(mContent, new FrameLayout.LayoutParams((int) (dimensions[0] * scale + 0.5f),
                (int) (dimensions[1] * scale + 0.5f)));
        
        return d;
    }
    
    
    private void setUpTitle(Dialog d) {
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        Drawable icon = getContext().getResources().getDrawable(R.drawable.ic_launcher);
        
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
        
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setWebViewClient(new StackWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(mUrl);
        mWebView.setLayoutParams(FILL);
        
        mContent.addView(mWebView);
    }

    private class StackWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
        	Log.d(TAG, "Redirecting URL " + url);
        	
        	/*if (url.startsWith(TwitterApp.CALLBACK_URL)) {
        		Log.d(TAG, "CallBack");
        		mListener.onComplete(url);
        		
        		StackOverflowDialog.this.dismiss();
        		
        		return true;
        	}  else if (url.startsWith("authorize")) {
        		Log.d(TAG, "authorize");
        		return false;
        	}*/
        	
            return false;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        	Log.d(TAG, "Page error: " + description);
        	
            super.onReceivedError(view, errorCode, description, failingUrl);
      
            mListener.onError(description);
            
            StackOverflowDialog.this.dismiss();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d(TAG, "Loading URL: " + url);
            super.onPageStarted(view, url, favicon);
            mSpinner.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mSpinner.dismiss();
        }

    }
    
    
    public interface SoDialogListener {
		public void onComplete(String value);
	
		public void onError(String value);
	}
}
