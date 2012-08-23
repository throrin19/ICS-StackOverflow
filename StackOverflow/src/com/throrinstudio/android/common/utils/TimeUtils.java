package com.throrinstudio.android.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.content.res.Configuration;
import android.provider.Settings;

import com.throrinstudio.android.stackexchange.Application;

public class TimeUtils {
	
	public static String getCurrentTimestamp(){
		Date date = new Date();
		return String.valueOf(date.getTime());
	}
	
	/**
	 * Récupère le fuseau horaire.
	 * @return Fuseau horaire.
	 */
	public static TimeZone getSystemTimeZone()
	{
		TimeZone tz = null;
		
		try {
			Configuration userConfig = new Configuration();
			
			Settings.System.getConfiguration( Application.getContext().getContentResolver(), userConfig );
			
			Calendar cal	= Calendar.getInstance( userConfig.locale );
			tz				= cal.getTimeZone();
		} catch(NullPointerException e) {
			tz = TimeZone.getDefault();
		}

		return tz;
	}
}
