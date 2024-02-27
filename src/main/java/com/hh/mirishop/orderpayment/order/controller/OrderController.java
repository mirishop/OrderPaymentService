package com.hh.mirishop.orderpayment.order.controller;


import com.hh.mirishop.orderpayment.common.dto.BaseResponse;
import com.hh.mirishop.orderpayment.order.dto.OrderAddressDto;
import com.hh.mirishop.orderpayment.order.dto.OrderCreate;
import com.hh.mirishop.orderpayment.order.enttiy.Order;
import com.hh.mirishop.orderpayment.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<BaseResponse<Void>> create(@RequestBody OrderCreate orderCreate,
                                                     @RequestHeader(name = "X-MEMBER-NUMBER") Long currentMemberNumber) {
        orderService.createOrder(orderCreate, currentMemberNumber);
        return ResponseEntity.ok(BaseResponse.of("결재 준비중 주문 생성 완료", true, null));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<BaseResponse<Void>> getOrder(@RequestBody OrderCreate orderCreate,
                                                       @RequestHeader(name = "X-MEMBER-NUMBER") Long currentMemberNumber) {
        orderService.createOrder(orderCreate, currentMemberNumber);
        return ResponseEntity.ok(BaseResponse.of("결재 준비중 주문 생성 완료", true, null));
    }

    @PutMapping("/{orderId}/address")
    public ResponseEntity<BaseResponse<Void>> addAddressToOrder(@PathVariable("orderId") Long orderId,
                                                                @RequestBody OrderAddressDto orderAddress) {
        orderService.addAddressToOrder(orderId, orderAddress);
        return ResponseEntity.ok(BaseResponse.of("주문에 주소 입력 완료", true, null));
    }

    @PutMapping("/{orderId}/complete")
    public ResponseEntity<BaseResponse<Void>> cancelOrder(@PathVariable("orderId") Long orderId,
                                                          @RequestHeader(name = "X-MEMBER-NUMBER") Long currentMemberNumber) {
        orderService.completeOrder(orderId, currentMemberNumber);
        return ResponseEntity.ok(BaseResponse.of("최종 주문 완료", true, null));
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<BaseResponse<Void>> completeOrder(@PathVariable("orderId") Long orderId,
                                                            @RequestHeader(name = "X-MEMBER-NUMBER") Long currentMemberNumber) {
        orderService.cancelOrder(orderId, currentMemberNumber);
        return ResponseEntity.ok(BaseResponse.of("주문 취소 완료", true, null));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<Page<Order>>> findAllOrders(
            @RequestHeader(name = "X-MEMBER-NUMBER") Long currentMemberNumber,
            Pageable pageable) {
        Page<Order> orders = orderService.findAllOrdersByMemberNumber(currentMemberNumber, pageable);
        return ResponseEntity.ok(BaseResponse.of("전체 주문 조회", true, orders));
    }
}
