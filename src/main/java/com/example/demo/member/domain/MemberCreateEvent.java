package com.example.demo.member.domain;

public record MemberCreateEvent(
	Member member
) {

	public static MemberCreateEvent of(Member member) {
		return new MemberCreateEvent(member);
	}
}
