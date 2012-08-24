package com.throrinstudio.android.stackexchange.libs.social.stackexchange.requesters;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;

public class StackExchangeRequester extends AbstractRequester{

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Fonction appelée pour lancer les requêtes propres à StackOverflow.
	 * 
	 * args attends au minimum le paramètres url pour pouvoir requêté dessus. 
	 * Toutes les requêtes sont effectuées en GET comme indiqué dans la documentation.
	 * 
	 * L'inputStream retourné est soit directement décompressé, soit directement gzippé, 
	 * tout dépend de ce que retourne l'API StackExchange
	 * 
	 * @params args
	 * 		Object...	tableaux de paramètres attendus par le Requester:
	 * 		<ul>
	 * 		 <li>
	 * 			[0] : 	String
	 * 					L'url de la requête
	 * 		 </li>
	 * 		 <li>
	 * 			[1] :	List<NameValuePair>
	 * 					Liste des paramètres à passer à l'API
	 * 		</ul>
	 * 
	 */
	public InputStream request(Object... args) {
		
		String url					= null;
		List<NameValuePair> list	= new ArrayList<NameValuePair>();
		InputStream			stream	= null;
		
		if(checkNetworkWithG()){
			
			if(args.length > 0){
				url = (String) args[0];
				
				if(args.length > 1){
					list = (ArrayList<NameValuePair>) args[1];
				}
				

				if(list.size() > 0){
					String params = URLEncodedUtils.format(list, "UTF-8");
					
					if(!url.endsWith("?"))
				        url += "?";
					
					
					url += params;
				}
				
				HttpClient client = initHttpClient();
				HttpGet httpget = new HttpGet(url);
				
				settDefaultHeaderOptions(httpget);
				
				
				stream = execute(client, httpget, getClass().getName());
			}
		}
		
		
		return stream;
	}

}
