package com.example.demo.member.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.application.MemberService;
import com.example.demo.member.application.dto.SignupRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<Void> signup(
		@RequestBody SignupRequest request
	) {
		memberService.signup(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
