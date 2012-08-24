package com.throrinstudio.android.common.libs.tasks;
public class Step
{
	private String	mName;
	private int		mNbIter;

	public Step(String name, int nbSubSteps)
	{
		super();
		this.mName = name;
		this.mNbIter = nbSubSteps;
	}

	public String getName()
	{
		return mName;
	}

	public int getNbIter()
	{
		return mNbIter;
	}
	
	public void setNbIter(int nbIter)
	{
		mNbIter = nbIter;
	}

}