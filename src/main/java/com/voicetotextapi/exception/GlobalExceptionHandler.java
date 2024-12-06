package com.voicetotextapi.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleIllegalArgumentException(IllegalArgumentException ex) {
		return Map.of(
				"error", "Bad Request",
				"message", ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handleGenericException(Exception ex) {
		return Map.of(
				"error", "Internal Server Error",
				"message", "An unexpected error occurred");
	}

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleCustomException(CustomException ex) {
		return Map.of(
				"error", "Bad Request",
				"message", ex.getMessage());
	}
}
