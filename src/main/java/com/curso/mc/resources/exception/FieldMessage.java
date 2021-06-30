package com.curso.mc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Variáveis
	private String fieldName;
	private String message;
	
	// Construtor vazio
	public FieldMessage() {}

	// Construtor povoado
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	// Gets e Sets
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	};
	
	
}
