package com.example.demo.common.exception;

public class BaseException extends RuntimeException {

	private final BaseExceptType exceptType;

	public BaseException(BaseExceptType type) {
		super(type.message());
		this.exceptType = type;
	}

	public BaseExceptType getType() {
		return exceptType;
	}
}
