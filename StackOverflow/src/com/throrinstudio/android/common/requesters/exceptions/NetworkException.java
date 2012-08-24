package com.throrinstudio.android.common.requesters.exceptions;

public class NetworkException extends Exception{
	private static final long serialVersionUID = 1L;

	public NetworkException() {
		super();
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public NetworkException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	/**
	 * @param detailMessage
	 */
	public NetworkException(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * @param throwable
	 */
	public NetworkException(Throwable throwable) {
		super(throwable);
	}

}
