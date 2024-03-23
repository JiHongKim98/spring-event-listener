package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EventRequest;
import com.example.demo.service.EventPublishService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EventController {

	private final EventPublishService eventPublishService;

	@PostMapping("/event")
	public void eventTest(
		@RequestBody EventRequest request
	) {
		eventPublishService.eventPublish(request);
	}
}
