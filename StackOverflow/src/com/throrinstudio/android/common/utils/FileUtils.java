package com.throrinstudio.android.common.utils;


public class FileUtils {

	public static String getFileExt(String file){
    	String[] explode = file.split("\\.");
    	String extension = "."+explode[explode.length-1];
    	
		return extension;
    }
    
    public static String getFileName(String file){
    	String[] explode = file.split("\\.");
    	String newFileName = implode(".", remove(explode.length-1, explode)); 	
    	
		return newFileName;
    }
    
    /***
	 * Fusionne les éléments d'un tableau en une chaîne
	 * @param delim : la chaîne de séparation
	 * @param args : la tableau
	 * @return la chaîne fusionnée
	 */
	public static String implode(String delim, String[] args){
		StringBuffer sb = new StringBuffer();
		
		for(int i =0; i < args.length; i++){
			if (i+1 > 1)
				sb.append(delim);
			
			sb.append(args[i]);
		}
		
		return sb.toString();
	}

	
	public static String[] remove(int index, String[] tab){
		String[] newarray = new String[tab.length-1];

		int newIndex = 0;
		for(int i = 0; i < tab.length; ++i){
			if(i != index){
				newarray[newIndex] = tab[i];
				newIndex++;
			}
		}
		return newarray;
	}
	
	/*public static int getFileTypeRessource(String filename){
		String ext = getFileExt(filename);
		
		System.out.println(ext);
		
		if(ext.equals(".ppt") || ext.equals(".pptx") || ext.equals(".pps") || ext.equals(".ppsx")){
			return R.drawable.ic_file_ppt;
		}else
		if(ext.equals(".doc") || ext.equals(".docx")){
			return R.drawable.ic_file_doc;
		}else
		if(ext.equals(".xls") || ext.equals(".xlsx")){
			return R.drawable.ic_file_xls;
		}else
		if(ext.equals(".pdf")){
			return R.drawable.ic_file_pdf;
		}else
		if(ext.equals(".mp3")){
			return R.drawable.ic_file_mp3;
		}else{
			return R.drawable.ic_file;
		}
	}*/
}
