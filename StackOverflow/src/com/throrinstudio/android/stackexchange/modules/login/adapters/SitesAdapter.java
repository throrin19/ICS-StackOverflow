package com.throrinstudio.android.stackexchange.modules.login.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.throrinstudio.android.common.libs.widgets.lazylist.ImageLoader;
import com.throrinstudio.android.stackexchange.R;
import com.throrinstudio.android.stackexchange.libs.social.stackexchange.entities.Site;

public class SitesAdapter extends BaseAdapter{

	private LayoutInflater mInflater;
	private List<Site> mSites;
	private ImageLoader mLoader;
	
	
	public SitesAdapter(Context c, List<Site> sites){
		super();
		
		mSites 		= sites;
		mInflater 	= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mLoader		 = new ImageLoader(c.getApplicationContext());
	}
	
	@Override
	public int getCount() {
		return mSites.size();
	}

	@Override
	public Site getItem(int arg0) {
		return mSites.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View vi = convertView;
        ViewHolder holder;
        if (convertView == null) {
        	vi = mInflater.inflate(R.layout.list_item_img_title_desc, null);
        	
        	holder = new ViewHolder();
        	holder.icon = (ImageView) vi.findViewById(R.id.list_icon);
        	holder.text = (TextView) vi.findViewById(R.id.list_title);
        	holder.desc = (TextView) vi.findViewById(R.id.list_desc);
        	
        	vi.setTag(holder);
        }else{
        	holder = (ViewHolder) vi.getTag();
        }
        
        Site site = getItem(position);
        holder.text.setText(site.getName());
        holder.desc.setText(site.getAudience());
        
        if(site.getIconUrl() != null && site.getIconUrl().length() > 0){
        	holder.icon.setTag(site.getIconUrl());
            mLoader.DisplayImage(site.getIconUrl(), holder.icon);
        }else if(site.getHighResolutionIconUrl() != null && site.getHighResolutionIconUrl().length() > 0){
        	holder.icon.setTag(site.getHighResolutionIconUrl());
            mLoader.DisplayImage(site.getHighResolutionIconUrl(), holder.icon);
        }
        
        
        
		return vi;
	}

	private class ViewHolder{
		public ImageView icon;
		public TextView text;
		public TextView desc;
	}
}
