package com.example.demo.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EventRequest;
import com.example.demo.event.ThreadEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventPublishService {

	private final ApplicationEventPublisher eventPublisher;

	public void eventPublish(EventRequest request) {
		String message = request.message();

		log.info("eventPublish :: 이벤트 발행");
		eventPublisher.publishEvent(ThreadEvent.of(message));
	}
}
