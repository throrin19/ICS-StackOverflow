package com.throrinstudio.android.common.utils;

import android.content.res.Resources;
import android.util.TypedValue;

import com.throrinstudio.android.stackexchange.Application;

public class MeasuresUtils
{

	public static int DpToPx(int dp)
	{
		Resources r = Application.getContext().getResources();
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dp, r.getDisplayMetrics());
		return px;
	}

	public static float PxToSp(float px)
	{
		float scaledDensity = Application.getContext()
				.getResources().getDisplayMetrics().scaledDensity;
		return px / scaledDensity;
	}

	public static float SpToPx(float sp)
	{
		Resources r = Application.getContext().getResources();
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
				sp, r.getDisplayMetrics());
		return px;
	}
}
