package com.example.demo.coupon.application;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.example.demo.coupon.domain.Coupon;
import com.example.demo.coupon.domain.repository.CouponRepository;
import com.example.demo.member.domain.MemberCreateEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponService {

	private final CouponRepository couponRepository;

	@Async
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void addCoupon(MemberCreateEvent event) {
		log.info("Coupon Service :: event receive");

		Coupon coupon = Coupon.builder()
			.memberId(event.member().getId())
			.build();
		couponRepository.save(coupon);
	}
}
