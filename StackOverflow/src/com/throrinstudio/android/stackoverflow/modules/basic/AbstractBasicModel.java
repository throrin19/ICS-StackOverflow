package com.throrinstudio.android.stackoverflow.modules.basic;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;

import com.throrinstudio.android.stackoverflow.providers.BasicProvider;

/**
 * Represent a basic model which extends GoomeoObservable
 * 
 */
public abstract class AbstractBasicModel
{
	protected BasicProvider		mProvider;

	/** Asynctasks list, killed on the onPause(); */
	private List<Object>		mTasksList;

	/**
	 * Add your task if you want to kill it when the fragment is hidden you
	 * should add the task in the onPreExecute method of your asynctask
	 * 
	 * @param task
	 */
	@SuppressWarnings("rawtypes")
	public void addTask(AsyncTask task)
	{
		mTasksList.add(task);
	}

	public void addTask(Thread task)
	{
		mTasksList.add(task);
	}

	/**
	 * Force stop all running tasks added previously
	 */
	@SuppressWarnings("rawtypes")
	public void cancelAllTasks()
	{
		for (Object task : mTasksList)
		{
			if (task != null)
			{
				if (task instanceof Thread)
				{
					((Thread) task).interrupt();
				}
				else if (task instanceof AsyncTask)
				{
					((AsyncTask) task).cancel(true);
				}
			}
		}
		mTasksList.clear();
	}

	/**
	 * Ctor: construct a new model initializing a new provider by the method
	 * {@link #initProvider}
	 */
	public AbstractBasicModel()
	{
		super();
		mTasksList = new ArrayList<Object>();
		mProvider = initProvider();
	}

	/**
	 * Initialize a new IProvider
	 * 
	 * @return IProvider initialized
	 */
	public abstract BasicProvider initProvider();

	public abstract BasicProvider getProvider();

	
}
