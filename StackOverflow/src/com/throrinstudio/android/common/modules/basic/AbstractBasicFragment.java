package com.throrinstudio.android.common.modules.basic;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public abstract class AbstractBasicFragment extends Fragment{

	/** Model of the fragment */
	protected AbstractBasicModel	mModel;

	@Override
	public void onPause()
	{
		if (mModel != null)
			mModel.cancelAllTasks();

		super.onPause();
	}

    public void onPauseWithoutStopTasks()
	{
		super.onPause();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View ret = inflater.inflate(getFragmentLayoutResource(), container,
				false);

		bindViews(ret);

		return ret;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		if (mModel == null)
		{
			mModel = initModel();
		}

		initViews();
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
	}

	/**
	 * Init views. eg. myView.setText("hi");
	 */
	protected abstract void initViews();

	/**
	 * Bind Views eg. myView = v.findViewById(R.id.myView)
	 */
	protected abstract void bindViews(View v);

	/**
	 * retrieve id of the view in xml layout (R.layout.etc)
	 * 
	 * @return view id
	 */
	public abstract int getFragmentLayoutResource();

	/**
	 * Initialisation of the model
	 * 
	 * @return AbstractBasicModel initialized
	 */
	public abstract AbstractBasicModel initModel();

	/**
	 * Shows a toast
	 * 
	 * @param msg
	 */
	public void showInfoMessage(final String msg)
	{
		Handler refresh = new Handler(Looper.getMainLooper());
		refresh.post(new Runnable()
		{
			public void run()
			{
				Toast.makeText(getActivity().getBaseContext(), msg,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

    @Override
    public void onDestroyView() {
        unbindDrawables(getView());

        super.onDestroyView();
    }

    @Override
	public void onDestroy()
	{
		super.onDestroy();
	}

    /**
     * Fonction utilisée pour l'enregistrement des stats
     */
    protected void statsAction(){

    }


    

    public void onStartWithoutIncrement(){
    	super.onStart();
    }
    
    public void onStopWithoutDecrmeent(){
    	super.onPause();
    }
    

    protected void unbindDrawables(View view) {
        if(view != null){
            if (view.getBackground() != null) {
                view.getBackground().setCallback(null);
                view.setBackgroundDrawable(null);
            }
            if (view instanceof ViewGroup) {
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    unbindDrawables(((ViewGroup) view).getChildAt(i));
                }
            }else
            if(view instanceof ImageView){
                if(((ImageView)view).getDrawable() != null){
                    ((ImageView)view).getDrawable().setCallback(null);
                    ((ImageView)view).setImageDrawable(null);
                }
            }
        }
    }

	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		
	}
}
