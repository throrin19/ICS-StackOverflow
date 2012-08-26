package com.throrinstudio.android.common.requesters;

import java.io.InputStream;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import com.throrinstudio.android.common.requesters.exceptions.NetworkException;
import com.throrinstudio.android.common.requesters.exceptions.RequesterException;
import com.throrinstudio.android.common.utils.LogManager;

public class ImageRequester extends AbstractRequester{

	@Override
	public InputStream request(Object... args)
			throws RequesterException, NetworkException {
		
		InputStream stream = null;
		
		if(checkNetworkWithG()){ // Si on a du réseau on effectue la requête. Sinon on ne fait rien
			HttpClient client = initHttpClient();
			HttpGet httpPost = new HttpGet((String) args[0]);
			
			settDefaultHeaderOptions(httpPost);
			
			stream = execute(client, httpPost, getClass().getName());

		}else{
			LogManager.log(LogManager.LEVEL_WARN, getClass().getName(), "Pas de réseau");
		}

		return stream;
	}
}
