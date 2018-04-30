package com.me.crud.exception;

public class StudentException extends Exception {
	
	public StudentException(String message)
	{
		super("UserException-"+message);
	}
	
	public StudentException(String message, Throwable cause)
	{
		super("UserException-"+message,cause);
	}	

}
