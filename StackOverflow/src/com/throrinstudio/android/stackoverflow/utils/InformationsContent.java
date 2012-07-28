package com.throrinstudio.android.stackoverflow.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.throrinstudio.android.stackoverflow.Application;

/**
 * Classe de récupération de la plupart des informations systèmes utiles
 * 
 * @author WEB
 * 
 */
public class InformationsContent {

	/**
	 * Récupère la version installée d'Android
	 * 
	 * @return Version installée sous la forme "2.2.3"
	 */
	public static String getAndroidVersion() {
		return Build.VERSION.RELEASE;
	}

	/**
	 * Récupère le modèle du téléphone
	 * 
	 * @return Modèle sous la forme "GT-I9100"
	 */
	public static String getPhoneModel() {
		return Build.MODEL;
	}

	/**
	 * Récupère le Constructeur du téléphone
	 * 
	 * @return Constructeur du téléphone sous la forme "Samsung"
	 */
	public static String getPhoneManufacturer() {
		return Build.MANUFACTURER;
	}

	/**
	 * Récupère l'ID du téléphone
	 * 
	 * @return ID du téléphone
	 */
	public static String getPhoneId() {
		ContentResolver contentResolver = Application
				.getContext().getContentResolver();
		TelephonyManager telephonyManager = (TelephonyManager) Application
				.getContext().getSystemService(
						Context.TELEPHONY_SERVICE);

		String id = telephonyManager.getDeviceId();
		if (id == null) {
			id = Secure.getString(contentResolver, Secure.ANDROID_ID);
		}

		return id;
	}

	/**
	 * Récupère la version de l'application sous la forme données par le Play
	 * Store
	 * 
	 * @return Numéro de version sous la forme 1.0.0
	 */
	public static String getApplicationVersion() {

		String version = "";

		try {
			Context ctx = Application.getContext();
			PackageInfo info = ctx.getPackageManager().getPackageInfo(
					ctx.getPackageName(), 0);
			version = info.versionName;
		} catch (NameNotFoundException e) {
			LogManager.log(LogManager.LEVEL_ERROR, "Application",
					"Erreur à la récupération de la version de l'application",
					e);
		}

		return version;
	}

	/**
	 * Récupère la résolution d'écran du téléphone
	 * 
	 * @return Résolution sous la forme "480x850"
	 */
	public static String getScreenSize() {
		WindowManager windowManager = (WindowManager) Application
				.getContext().getSystemService(
						Context.WINDOW_SERVICE);

		DisplayMetrics metrics = new DisplayMetrics();
		windowManager.getDefaultDisplay().getMetrics(metrics);

		return Integer.toString(metrics.widthPixels) + "x"
				+ Integer.toString(metrics.heightPixels);
	}

	/**
	 * Récupère la densité de l'écran du téléphone
	 * 
	 * @return Densité sous la forme "160"
	 */
	public static String getScreenDensity() {
		WindowManager windowManager = (WindowManager) Application
				.getContext().getSystemService(
						Context.WINDOW_SERVICE);

		DisplayMetrics metrics = new DisplayMetrics();
		windowManager.getDefaultDisplay().getMetrics(metrics);

		return String.valueOf(metrics.densityDpi);
	}

	public static enum Orientation {
		Portrait, Landscape
	}
	
	public static Orientation getScreenOrientation() {
		Display display = ((WindowManager) Application
				.getContext().getSystemService(
						Context.WINDOW_SERVICE)).getDefaultDisplay();

		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		
		if(metrics.widthPixels > metrics.heightPixels){
			return Orientation.Landscape;
		}else{
			return Orientation.Portrait;
		}
	}
	
	public static DisplayMetrics getMetrics(){
		Display display = ((WindowManager) Application
				.getContext().getSystemService(
						Context.WINDOW_SERVICE)).getDefaultDisplay();

		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		
		return metrics;
	}
	
	public static Display getDisplay(){
		Display display = ((WindowManager) Application
				.getContext().getSystemService(
						Context.WINDOW_SERVICE)).getDefaultDisplay();

		
		return display;
	}

    public static int getScreenWidth(){
        return getDisplay().getWidth();
    }

    public static int getScreenHeight(){
        return getDisplay().getHeight();
    }
}
