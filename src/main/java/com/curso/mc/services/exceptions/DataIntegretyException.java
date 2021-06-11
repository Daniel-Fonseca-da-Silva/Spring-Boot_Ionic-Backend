package com.curso.mc.services.exceptions;

public class DataIntegretyException extends RuntimeException {

	private static final long serialVersionUID = -64439292504727265L;
	
	public DataIntegretyException(String msg) {
		super(msg);
	}
	
	public DataIntegretyException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
