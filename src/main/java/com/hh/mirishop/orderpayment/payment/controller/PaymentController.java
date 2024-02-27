package com.hh.mirishop.orderpayment.payment.controller;

import com.hh.mirishop.orderpayment.common.dto.BaseResponse;
import com.hh.mirishop.orderpayment.payment.dto.PaymentCreate;
import com.hh.mirishop.orderpayment.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<BaseResponse<Void>> process(PaymentCreate paymentCreate) {
        paymentService.createPayment(paymentCreate.getOrderId(), paymentCreate.getMemberNumber());

        return ResponseEntity.ok(BaseResponse.of("결제 성공", true, null));
    }
}
