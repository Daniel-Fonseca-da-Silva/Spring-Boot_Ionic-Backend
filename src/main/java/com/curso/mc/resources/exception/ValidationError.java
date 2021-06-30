package com.curso.mc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	// Variáveis
	private List<FieldMessage> errors = new ArrayList<>();

	private static final long serialVersionUID = 1L;
	
	// Construtor povoado
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	// Gets e Sets
	public List<FieldMessage> getErrors() {
		return errors;
	}
	// Set!
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}