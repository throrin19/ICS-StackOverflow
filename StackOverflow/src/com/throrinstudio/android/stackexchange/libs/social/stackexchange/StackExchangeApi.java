package com.throrinstudio.android.stackexchange.libs.social.stackexchange;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.Handler;

import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.User;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.mappers.MapperFacade;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.mappers.MapperFacade.MapperType;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.requesters.StackExchangeRequester;

/**
 * A sample implementation of asynchronous API requests. This class provides
 * the ability to execute API methods and have the call return immediately,
 * without blocking the calling thread. This is necessary when accessing the
 * API in the UI thread, for instance. The request response is returned to 
 * the caller via a callback interface, which the developer must implement.
 *
 * This sample implementation simply spawns a new thread for each request,
 * and makes the API call immediately.  This may work in many applications,
 * but more sophisticated users may re-implement this behavior using a thread
 * pool, a network thread, a request queue, or other mechanism.  Advanced
 * functionality could be built, such as rate-limiting of requests, as per
 * a specific application's needs.
 *
 * @see RequestListener
 *        The callback interface.
 *
 * @author  throrin19 (contact@throrinstudio.com)
 */
public class StackExchangeApi {
	
	private static final String API_URL = "https://api.stackexchange.com/2.1/";
	
	private Handler mHandler = new Handler();
	
	public void getSitesList(Context ctx, final RequestListener listener){
		
		new Thread(){
			@Override
			public void run() {
				super.run();
				
				StackExchangeRequester requester = new StackExchangeRequester();
				MapperFacade<Site> mapper = new MapperFacade<Site>();
				
				InputStream stream = requester.request(API_URL+"/sites/");
				
				final List<Site> sites = mapper.mapList(stream, MapperType.site);
				
				
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						if(sites != null){
							listener.onComplete(sites);
						}else{
							listener.onError(new StackExchangeError("Impossible de récupérer la liste des sites"), null);
						}
					}
				});
				
			}		
		}.start();
	}
	
	public void getUser(Context ctx, final String accesstoken, final RequestListener listener){
		new Thread(){
			@Override
			public void run() {
				super.run();
				
				StackExchangeRequester requester 	= new StackExchangeRequester();
				MapperFacade<User> mapper 			= new MapperFacade<User>();
				List<NameValuePair> params 			= new ArrayList<NameValuePair>();
				
				params.add(new BasicNameValuePair("access_token", accesstoken));
				
				InputStream stream 	= requester.request(API_URL+"/me", params);
				List<User> users 	= mapper.mapList(stream, MapperType.user);
				if(users.size() > 0){
					final User user = users.get(0);
					mHandler.post(new Runnable() {
						@Override
						public void run() {
							listener.onComplete(user);
						}
					});
				}else{
					mHandler.post(new Runnable() {
						@Override
						public void run() {
							listener.onError(new StackExchangeError("Impossible de récupérer l'utilisateur"), null);
						}
					});
				}
			}		
		}.start();
	}
	
	
	/**
     * Callback interface for API requests.
     *
     * Each method includes a 'state' parameter that identifies the calling
     * request. It will be set to the value passed when originally calling the
     * request method, or null if none was passed.
     */
    public static interface RequestListener {

        /**
         * Called when a request completes with the given response.
         */
        public void onComplete(Object state);

        /**
         * Called when a request has a network or request error.
         */
        public void onIOException(IOException e, Object state);

        /**
         * Called when the server-side Facebook method fails.
         */
        public void onError(StackExchangeError e, Object state);

    }
}
