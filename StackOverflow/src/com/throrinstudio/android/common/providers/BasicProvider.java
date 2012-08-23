package com.throrinstudio.android.common.providers;


public class BasicProvider
{
	protected static BasicProvider	instance	= null;

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
	
	public void initData(){
		
	}
	
	public static void resetSingleton(){
		instance = null;
	}
}
