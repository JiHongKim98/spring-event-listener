package com.example.demo.member.application;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.application.dto.SignupRequest;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberCreateEvent;
import com.example.demo.member.domain.repository.MemberRepository;
import com.example.demo.member.exception.MemberExceptType;
import com.example.demo.member.exception.MemberException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final ApplicationEventPublisher eventPublisher;

	@Transactional
	public void signup(SignupRequest request) {
		memberRepository.findByUsername(request.username()).ifPresent(it -> {
			throw new MemberException(MemberExceptType.ALREADY_EXIST_USERNAME);
		});

		Member newMember = request.toEntity();

		log.info("Member Service :: Save new member");
		memberRepository.save(newMember);

		log.info("Member Service :: publish member event");
		eventPublisher.publishEvent(MemberCreateEvent.of(newMember));
	}
}
