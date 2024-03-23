package com.example.demo.service;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.event.ThreadEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EventListenerService {

	@Async
	@EventListener
	public void receiveEvent1(ThreadEvent event) throws InterruptedException {
		Thread.sleep(1000);  // 1초 대기
		log.info("1번 받은 이벤트 = {}", event.message());
	}

	@Async
	@EventListener
	public void receiveEvent2(ThreadEvent event) throws InterruptedException {
		Thread.sleep(2000);  // 2초 대기
		log.info("2번 받은 이벤트 = {}", event.message());
	}

	@Async
	@EventListener
	public void receiveEvent3(ThreadEvent event) throws InterruptedException {
		Thread.sleep(3000);  // 3초 대기
		log.info("3번 받은 이벤트 = {}", event.message());
	}
}
