package com.hh.mirishop.orderpayment.payment.service;

public interface PaymentService {

    Long createPayment(Long orderId, Long currentMemberNumber);
}
