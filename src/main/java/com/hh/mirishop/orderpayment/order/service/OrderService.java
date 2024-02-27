package com.hh.mirishop.orderpayment.order.service;

import com.hh.mirishop.orderpayment.order.dto.OrderAddressDto;
import com.hh.mirishop.orderpayment.order.dto.OrderCreate;
import com.hh.mirishop.orderpayment.order.enttiy.Order;

import java.util.List;

public interface OrderService {

    Long createOrder(OrderCreate orderCreate, Long currentMemberNumber);

    void addAddressToOrder(Long orderId, OrderAddressDto address);

    void completeOrder(Long orderId, Long currentMemberNumber);

    void cancelOrder(Long orderId, Long currentMemberNumber);

    List<Order> findAllOrdersByMemberNumber(Long memberNumber);
}
