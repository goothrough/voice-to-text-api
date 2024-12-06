package com.voicetotextapi.exception;

public class CustomException extends RuntimeException {
	private final String errorMessage;

	public CustomException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}
}