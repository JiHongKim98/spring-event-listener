package com.example.demo.member.application.dto;

import com.example.demo.member.domain.Member;

public record SignupRequest(
	String username
) {

	public Member toEntity() {
		return Member.builder()
			.username(username)
			.build();
	}
}
