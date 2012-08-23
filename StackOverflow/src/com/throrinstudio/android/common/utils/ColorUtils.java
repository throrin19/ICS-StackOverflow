package com.throrinstudio.android.common.utils;

import android.graphics.Color;

public class ColorUtils {

	public static final int getAVGColor(int c1, int c2){
		int r1 = Color.red(c1);
		int g1 = Color.green(c1);
		int b1 = Color.blue(c1);
		
		int r2 = Color.red(c2);
		int g2 = Color.green(c2);
		int b2 = Color.blue(c2);
		
		int avgColor = Color.rgb((r1+r2)/2, (g1+g2)/2, (b1+b2)/2);
		
		return avgColor;
	}
	
	public static final int getInvertColor(int color){
		int moyHead = Color.red(color) + Color.green(color)+ Color.blue(color);
		int moy = 384;
		
		
		if(moyHead > moy){
			//assombrir
			int r = Color.red(moyHead) - 20;
			int g = Color.green(moyHead) - 20;
			int b = Color.blue(moyHead) - 20;
			
			return Color.rgb(r, g, b);
		}else{
			//assombrir
			int r = Color.red(moyHead) + 20;
			int g = Color.green(moyHead) + 20;
			int b = Color.blue(moyHead) + 20;
			
			return Color.rgb(r, g, b);
		}
	}
}
