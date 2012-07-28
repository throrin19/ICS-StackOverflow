package com.throrinstudio.android.stackoverflow.modules.basic;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import com.throrinstudio.android.stackoverflow.Application;

public abstract class AbstractBasicActivity extends Activity{

	/**
    *
    */
   private static final long serialVersionUID = 1089420541814611302L;

   @Override
   protected void onCreate(Bundle savedInstance) {
       super.onCreate(savedInstance);

       if (savedInstance == null) {
           getFragmentManager().beginTransaction()
                   .add(getResourceFragment(), getFragment()).commit();
       }
   }



   /**
    * Retrieve the associated fragment of the activity
    *
    * @return Fragment
    */
   protected abstract AbstractBasicFragment getFragment();

   protected abstract String getFragmentTag();

   /**
    * Retrieve default resource for the view
    *
    * @return android.R.id.content
    */
   protected int getResourceFragment() {
       return android.R.id.content;
   }
   
   @Override
   public void onConfigurationChanged(Configuration newConfig) {
       super.onConfigurationChanged(newConfig);
   }
	
	
}
