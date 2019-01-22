package com.fuber.cabbooking.exception;

public class FuberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Throwable exception;

	public FuberException(Throwable throwable){
		super(throwable);
		this.exception = throwable;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}
	
	
}
