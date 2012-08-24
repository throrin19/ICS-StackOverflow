package com.throrinstudio.android.common.requesters.exceptions;

public class RequesterException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public RequesterException() {
		super();
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public RequesterException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	/**
	 * @param detailMessage
	 */
	public RequesterException(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * @param throwable
	 */
	public RequesterException(Throwable throwable) {
		super(throwable);
	}
}
