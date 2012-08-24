package com.throrinstudio.android.stackexchange.libs.social.stackexchange.requesters;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.throrinstudio.android.common.requesters.exceptions.NetworkException;
import com.throrinstudio.android.common.requesters.exceptions.RequesterException;
import com.throrinstudio.android.common.utils.LogManager;
import com.throrinstudio.android.common.utils.StreamUtils;
import com.throrinstudio.android.stackexchange.Application;

/**
 * Classe parente de chaque Requester
 * @author WEB
 *
 */
public abstract class AbstractRequester {
	
	protected static final boolean DEBUG_STREAM = false;

	protected HttpUriRequest mRequest;
	protected HttpClient mClient;
	
	/**
	 * Fonction de requêtage sur le Web pour récupérer les données demandées
	 * @param args
	 * 		String... valeurs des paramètres supplémentaires pour la requête
	 * @return
	 * 		InputStream le flux de retour ou null si une erreur est survenue
	 * @throws RequesterException
	 * @throws NetworkException 
	 */
	public abstract InputStream request(Object... args);
	
	/**
	 * Fonction retournant les en-têtes obligatoires pour chaque requête
	 */
	protected void settDefaultHeaderOptions(AbstractHttpMessage httpRequest)
	{
		httpRequest.addHeader("Accept-Encoding", "deflate, gzip");
	}
	
	/**
	 * Fonction attribuant les settings pardéfaut des requêtes
	 * @return 
	 */
	protected HttpParams getDefaultHttpSettings()
	{
		HttpParams httpParameters = new BasicHttpParams();
		
		// On met le timeout à 15s
		int timeoutConnection = 15000;
		HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		
		return httpParameters;
	}
	
	/**
	 * Fonction permettant de vérifier l'état du réseau
	 * @return true if Network is ok false otherwise or GPRS is detected
	 * @throws NetworkException 
	 */
	protected boolean checkNetwork(){
		
		ConnectivityManager connectivity = (ConnectivityManager) Application.getContext()
											.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
		
		boolean isWifi = false;
		boolean is2gplus = false;
		
		boolean isConnected = (	activeNetwork != null  && 
								activeNetwork.isConnectedOrConnecting());

		if(isConnected){
			int connectionType = activeNetwork.getType();
			if(connectionType == ConnectivityManager.TYPE_WIFI){
				isWifi = true;
			}else{
				int subType = activeNetwork.getSubtype();
				if( subType != TelephonyManager.NETWORK_TYPE_GPRS && 		// La connexion mobile doit être différente
					subType != TelephonyManager.NETWORK_TYPE_UNKNOWN)       // de GPRS ou inconnue. Revient à faire (> 2G)
				{
					is2gplus = true;
				}
			}
		}
		
		if((isConnected && isWifi) || (isConnected && is2gplus) == true){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Fonction permettant de vérifier l'état du réseau
	 * @return true if Network is ok false otherwise or GPRS is detected
	 */
	protected boolean checkNetworkWithG(){
		
		ConnectivityManager connectivity = (ConnectivityManager) Application.getContext()
											.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
		
		boolean isWifi = false;
		boolean is2gplus = false;
		
		boolean isConnected = (	activeNetwork != null  && 
								activeNetwork.isConnectedOrConnecting());
		
		
		if(isConnected){
			int connectionType = activeNetwork.getType();
			if(connectionType == ConnectivityManager.TYPE_WIFI){
				isWifi = true;
			}else{
				int subType = activeNetwork.getSubtype();
				if( subType != TelephonyManager.NETWORK_TYPE_UNKNOWN)       // inconnue
				{
					is2gplus = true;
				}
			}
		}
		
		if((isConnected && isWifi) || (isConnected && is2gplus) == true){
			return true;
		}else{
			return false;
		}
	}
	

	/**
	 * Fonction retournant l'HTTPClient de base avec les réglages par défaut
	 * @return l'HTTPClient configuré
	 */
	protected HttpClient initHttpClient(){
		mClient = new DefaultHttpClient(getDefaultHttpSettings());
		return mClient;
	}

	/**
	 * Partie d'exécution de la requête HTTP
	 * @param client
	 * 		{@link HttpClient}	Client pour l'exécution de notre Requester
	 * @param request
	 * 		{@link HttpUriRequest} Notre objet Request ( {@link HttpPost} | {@link HttpGet} | {@link HttpPut} | {@link HttpDelete} )
	 * @param tag
	 * 		String le tag pour les logs
	 * @return {@link InputStream} Notre flux prêt à l'emplois.
	 * @throws RequesterException 
	 * @throws NetworkException 
	 */
	protected InputStream execute(HttpClient client, HttpUriRequest request, String tag){
		InputStream stream = null;
		
		LogManager.log(LogManager.LEVEL_INFO, tag, "Lancement de la requête");
		
		try{
			mRequest					= request;
			HttpResponse httpResponse 	= client.execute(request);
			HttpEntity httpEntity 		= httpResponse.getEntity();
			Header contentEncoding		= httpResponse.getFirstHeader("Content-Encoding");
			httpResponse.setEntity(null);
			httpResponse				= null;
			client						= null;
			request						= null;
			
			
			LogManager.log(LogManager.LEVEL_INFO, tag, "Réception de la réponse");
	
			if(httpEntity != null){
				LogManager.log(LogManager.LEVEL_INFO, tag, "Réponse non vide.");
				
				if(contentEncoding != null && contentEncoding.getValue().equals("gzip")){
					LogManager.log(LogManager.LEVEL_INFO, tag, "Réponse gzipée.");
					stream = new GZIPInputStream(httpEntity.getContent());
				}else{
					LogManager.log(LogManager.LEVEL_INFO, tag, "Réponse non compressée.");
					stream = httpEntity.getContent();
				}
				
				httpEntity = null;
			}
			
			if(DEBUG_STREAM){
				LogManager.log(LogManager.LEVEL_DEBUG, tag, StreamUtils.getInflatedString(stream));
				stream = null;
			}
		} catch(ClientProtocolException e){
			Log.e(getClass().getName(), "ClientProtocolException", e);
		} catch(IllegalStateException e) {
			Log.e(getClass().getName(), "IllegalStateException", e);
		} catch(IOException e){
			Log.e(getClass().getName(), "IOException", e);
		}
		
		return stream;
	}
	
	public void abort(){
		if(mRequest != null){
			mRequest.abort();
		}
		if(mClient != null){
			mClient.getConnectionManager().shutdown();
		}
	}
}