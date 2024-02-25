package com.hh.mirishop.orderpayment.order.controller;


import com.hh.mirishop.orderpayment.common.dto.BaseResponse;
import com.hh.mirishop.orderpayment.order.dto.OrderCreate;
import com.hh.mirishop.orderpayment.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<BaseResponse<Void>> create(@RequestBody OrderCreate orderCreate,
                                                     @RequestHeader(name = "X-MEMBER-NUMBER") Long currentMemberNumber) {
        orderService.createOrder(orderCreate, currentMemberNumber);
        return ResponseEntity.ok(BaseResponse.of("주문 생성 완료", true, null));
    }

    @PostMapping("/orders/{orderId}/cancel")
    public ResponseEntity<BaseResponse<Void>> cancelOrder(@PathVariable("orderId") Long orderId,
                                                          @RequestHeader(name = "X-MEMBER-NUMBER") Long currentMemberNumber) {
        orderService.cancelOrder(orderId, currentMemberNumber);
        return ResponseEntity.ok(BaseResponse.of("주문 취소 완료", true, null));
    }
}
