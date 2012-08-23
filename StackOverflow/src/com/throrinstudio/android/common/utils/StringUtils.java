package com.throrinstudio.android.common.utils;


public class StringUtils
{

	public static boolean isNullOrEmpty(String... strings)
	{
		for (String string : strings)
		{
			if (string != null && string.length() > 0)
				return false;
		}
		return true;
	}

	public static String arrayToString(String[] a, String separator) {
	    if (a != null && a.length > 0) {
	    	StringBuffer result = new StringBuffer();
	        result.append(a[0]);
	        for (int i=1; i<a.length; i++) {
	            result.append(separator);
	            result.append(a[i]);
	        }
	        return result.toString();
	    }
	    return null;
	}
	
	/**
	 * fonction permettant de convertir un array String en array Int si possible
	 * @param sarray
	 * @return
	 * @throws Exception
	 */
	public static int[] convertStringArraytoIntArray(String[] sarray) {
		int intarray[] = null;
		
		if (sarray != null) {
			intarray = new int[sarray.length];
			
			try {
				for (int i = 0; i < sarray.length; i++) {
						intarray[i] = Integer.parseInt(sarray[i]);
				}
			} catch (NumberFormatException e) {
				LogManager.logError("Erreur lors de la conversion d'un tableau de chaînes en tableau d'entiers...", e);
			}
		}
		
		return intarray;
	}
	
	/**
	 * fonction permettant de convertir un array String en array Int si possible
	 * @param sarray
	 * @return
	 * @throws Exception
	 */
	public static Integer[] convertStringArraytoIntegerArray(String[] sarray) {
		Integer[] intarray = null;
		
		if (sarray != null) {
			intarray = new Integer[sarray.length];
			
			try {
				for (int i = 0; i < sarray.length; i++) {
						intarray[i] = Integer.parseInt(sarray[i]);
				}
			} catch (NumberFormatException e) {
				LogManager.logError("Erreur lors de la conversion d'un tableau de chaînes en tableau d'entiers...", e);
			}
		}
		
		return intarray;
	}
	
	public static Float[] convertStringArraytoFloatArray(String[] sarray) {
		Float[] intarray = null;
		
		if (sarray != null) {
			intarray = new Float[sarray.length];
			
			try {
				for (int i = 0; i < sarray.length; i++) {
						intarray[i] = Float.parseFloat(sarray[i]);
				}
			} catch (NumberFormatException e) {
				LogManager.logError("Erreur lors de la conversion d'un tableau de chaînes en tableau d'entiers...", e);
			}
		}
		
		return intarray;
	}
}
