package com.example.demo.coupon.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.coupon.domain.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
