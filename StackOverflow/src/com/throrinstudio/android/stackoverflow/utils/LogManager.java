package com.throrinstudio.android.stackoverflow.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import android.util.Log;

import com.throrinstudio.android.stackoverflow.Application;

/**
 * Classe utilitaire permettant de gérer les logs de l'application.
 * @author Antoine Domenger
 */
public class LogManager
{
	public static final int LEVEL_INFO		= 0;
	public static final int LEVEL_DEBUG 	= 1;
	public static final int LEVEL_ERROR		= 2;
	public static final int LEVEL_VERBOSE	= 3;
	public static final int LEVEL_WARN		= 4;
	public static final int LEVEL_MAIL		= 5;
	
	/** Vrai si l'application est en mode développeur, faux sinon. */
	private static boolean	developerMode	= true;
	
	/** Nom de l'application. */
	private static String	applicationName	= null;
	
	/**
	 * Initialise les paramètres.
	 */
	private static void init()
	{
		if( applicationName == null )
		{
			developerMode	= Application.isLog();
			applicationName	= Application.getApplicationPackageName();
		}
	}
	
	/**
	 * Enregistre le message dans les logs au niveau souhaité, avec la possibilité d'ajouter une exception.
	 * @param level		Niveau de log
	 * @param message	Message
	 * @param e			Exception
	 */
	public static void log( int level, String tag, String message, Throwable e )
	{
		init();
		
		String logTag = applicationName;
		
		if(tag != null) {
			logTag = tag;
		}
		
		if( developerMode )
		{
			switch( level )
			{
			case LEVEL_INFO:
				if( e != null )
				{
					Log.i( logTag, message, e );
				}
				else
				{
					Log.i( logTag, message );
				}
				break;
			case LEVEL_DEBUG:
				if( e != null )
				{
					Log.d( logTag, message, e );
				}
				else
				{
					Log.d( logTag, message );
				}
				break;
			case LEVEL_ERROR:
				if( e != null )
				{
					Log.e( logTag, message, e );
				}
				else
				{
					Log.e( logTag, message );
				}
				break;
			case LEVEL_VERBOSE:
				if( e != null )
				{
					Log.v( logTag, message, e );
				}
				else
				{
					Log.v( logTag, message );
				}
				break;
			case LEVEL_WARN:
				if( e != null )
				{
					Log.w( logTag, message, e );
				}
				else
				{
					Log.w( logTag, message );
				}
				break;
			case LEVEL_MAIL:
				if( e != null )
				{
					Log.e( logTag, message, e );
					sendMail(message, e);
				}
				else
				{
					Log.e( logTag, message );
					sendMail(message, null);
				}
				break;
			default:
				log( LEVEL_INFO, logTag, message, null );
				break;
			}
		}
	}
	
	public static void log( int level, String tag, String message )
	{
		log(level, tag, message, null);
	}
	
	public static void logInformation( String tag, String message )
	{
		log( LEVEL_INFO, tag, message );
	}
	
	public static void logWarning( String tag, String message )
	{
		log( LEVEL_WARN, tag, message );
	}
	
	public static void logDebug( String tag, String message )
	{
		log( LEVEL_DEBUG, tag, message );
	}
	
	public static void logError( String tag, String message )
	{
		log( LEVEL_ERROR, tag, message );
	}
	
	public static void logError( String tag, String message, Throwable e )
	{
		log( LEVEL_ERROR, tag, message, e );
	}
	
	public static void logVerbose( String tag, String message )
	{
		log( LEVEL_VERBOSE, tag, message );
	}
	
	public static void logInformation( String message )
	{
		logInformation( null, message );
	}
	
	public static void logWarning( String message )
	{
		logWarning( null, message );
	}
	
	public static void logDebug( String message )
	{
		logDebug( null, message );
	}
	
	public static void logError( String message )
	{
		logError( null, message );
	}
	
	public static void logError( String message, Exception e )
	{
		logError( null, message, e );
	}
	
	public static void logVerbose( String message )
	{
		logVerbose( null, message );
	}
	
	
	private static void sendMail(String message, Throwable e){
		
		String stacktrace = "";
		if(e != null){
			final Writer result = new StringWriter();
	        final PrintWriter printWriter = new PrintWriter(result);
	        e.printStackTrace(printWriter);
	        stacktrace = result.toString();
	        printWriter.close();
		}
		
		new SendServer(stacktrace, message).start();
	}
	
	
	private static class SendServer extends Thread{
		
    	private String stack;
    	private String message;
    	
		public SendServer(String stacktrace, String message){
			super();
			this.stack = stacktrace;
			this.message = message;
		}
		
		public void run() {
			
	        /*ErrorRequester requester = new ErrorRequester();
	        try {
				requester.request(Application.getEventId(), message, stack);
			} catch (RequesterException e) {
				e.printStackTrace();
			} catch (NetworkException e) {
				e.printStackTrace();
			}*/
		}
	}
}
