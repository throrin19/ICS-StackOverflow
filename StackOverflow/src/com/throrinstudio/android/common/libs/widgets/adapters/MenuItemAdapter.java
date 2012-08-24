package com.throrinstudio.android.common.libs.widgets.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.entities.Item;

public class MenuItemAdapter extends ArrayAdapter<Item> {

	private Context 		mContext;
	private int 			mId;
	private ArrayList<Item> mItems;
	private int 			txtColor;
	
	
	public MenuItemAdapter(Context context, int resource, int textViewResourceId, ArrayList<Item> objects) {
		super(context, resource, textViewResourceId, objects);
		
		this.mContext 	= context;
		this.mId		= textViewResourceId;
		this.mItems		= objects;
	}
	
	public MenuItemAdapter(Context context, int resource, int textViewResourceId, ArrayList<Item> objects, int txtColor) {
		super(context, resource, textViewResourceId, objects);
		
		this.mContext 	= context;
		this.mId		= textViewResourceId;
		this.mItems		= objects;
		this.txtColor	= txtColor;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
        //User super class to create the View
        View v = super.getView(position, convertView, parent);
        TextView tv = (TextView)v.findViewById(mId);
        
        if(txtColor != 0){
        	tv.setTextColor(txtColor);
        }
        
        //Put the image on the TextView
        tv.setCompoundDrawablesWithIntrinsicBounds(mItems.get(position).icon, 0, 0, 0);

        //Add margin between image and text (support various screen densities)
        int dp5 = (int) (5 * mContext.getResources().getDisplayMetrics().density + 0.5f);
        tv.setCompoundDrawablePadding(dp5);
        
        return v;
    }

}