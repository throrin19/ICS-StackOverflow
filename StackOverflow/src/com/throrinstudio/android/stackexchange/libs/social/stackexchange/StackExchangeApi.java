package com.throrinstudio.android.stackexchange.libs.social.stackexchange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

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
	
	private static final String API_URL = "https://api.stackexchange.com";
	
	public void getSitesList(RequestListener listener){
		
		new Thread(){
			@Override
			public void run() {
				super.run();
				
				StackExchangeRequester requester = new StackExchangeRequester();
				final InputStream stream = requester.request(API_URL+"/sites");
				
				new Runnable() {
					@Override
					public void run() {
						
						
					}
				}.run();
				
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
        public void onComplete(String response, Object state);

        /**
         * Called when a request has a network or request error.
         */
        public void onIOException(IOException e, Object state);

        /**
         * Called when a request fails because the requested resource is
         * invalid or does not exist.
         */
        public void onFileNotFoundException(FileNotFoundException e,
                                            Object state);

        /**
         * Called if an invalid graph path is provided (which may result in a
         * malformed URL).
         */
        public void onMalformedURLException(MalformedURLException e,
                                            Object state);

        /**
         * Called when the server-side Facebook method fails.
         */
        public void onError(StackExchangeError e, Object state);

    }
}
