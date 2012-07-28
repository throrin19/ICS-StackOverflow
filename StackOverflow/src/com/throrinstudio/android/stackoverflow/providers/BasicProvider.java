package com.throrinstudio.android.stackoverflow.providers;


public class BasicProvider
{
	private static BasicProvider	instance	= null;
	private long					mEventId;

	// SINGLETON//////////////////////////////////////////////////////////////
	public static BasicProvider getInstance()
	{
		if (instanceNullOrOld(instance))
		{
			synchronized (BasicProvider.class)
			{
				if (instanceNullOrOld(instance))
				{
					instance = new BasicProvider();
				}
			}
		}
		return instance;
	}

	protected BasicProvider()
	{
		super();
	}

	protected static boolean instanceNullOrOld(BasicProvider instance)
	{
		if (instance == null)
		{
			return true;
		}
		return false;
	}

	public long getCurrentId()
	{
		return mEventId;
	}
	
	public void initData(){
		
	}
	
	public static void resetSingleton(){
		instance = null;
	}
}
