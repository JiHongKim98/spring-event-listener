package com.example.demo.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.demo.event.ThreadEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EventListenerService {

	@EventListener
	public void receiveEvent1(ThreadEvent event) throws InterruptedException {
		log.info("1번 받은 이벤트 = {}", event.message());
	}

	@EventListener
	public void receiveEvent2(ThreadEvent event) throws InterruptedException {
		log.info("2번 받은 이벤트 = {}", event.message());
	}

	@EventListener
	public void receiveEvent3(ThreadEvent event) throws InterruptedException {
		log.info("3번 받은 이벤트 = {}", event.message());
	}
}
