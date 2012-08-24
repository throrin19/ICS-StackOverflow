package com.throrinstudio.android.stackexchange.libs.social.stackexchange;

public class StackExchangeError extends Throwable {

    private static final long serialVersionUID = 1L;

    private int mErrorCode = 0;
    private String mErrorType;

    public StackExchangeError(String message) {
        super(message);
    }

    public StackExchangeError(String message, String type, int code) {
        super(message);
        mErrorType = type;
        mErrorCode = code;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public String getErrorType() {
        return mErrorType;
    }
}