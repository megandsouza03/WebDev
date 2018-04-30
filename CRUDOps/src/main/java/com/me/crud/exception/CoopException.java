package com.me.crud.exception;

public class CoopException extends Exception {
	
	public CoopException(String message)
	{
		super("CoopException-"+message);
	}
	
	public CoopException(String message, Throwable cause)
	{
		super("CoopException-"+message,cause);
	}	

}
