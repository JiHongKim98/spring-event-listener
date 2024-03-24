package com.example.demo.member.exception;

import org.springframework.http.HttpStatus;

import com.example.demo.common.exception.BaseExceptType;

public enum MemberExceptType implements BaseExceptType {
	ALREADY_EXIST_USERNAME(HttpStatus.BAD_REQUEST, "이미 존재하는 username 입니다."),
	;

	private final HttpStatus status;
	private final String message;

	MemberExceptType(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public String code() {
		return this.name();
	}

	@Override
	public HttpStatus status() {
		return this.status;
	}
}
