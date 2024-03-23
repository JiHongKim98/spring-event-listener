package com.example.demo.event;

public record ThreadEvent(
	String message
) {

	public static ThreadEvent of(String message) {
		return new ThreadEvent(message);
	}
}
