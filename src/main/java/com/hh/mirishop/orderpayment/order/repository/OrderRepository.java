package com.hh.mirishop.orderpayment.order.repository;

import com.hh.mirishop.orderpayment.order.enttiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.memberNumber = :memberNumber")
    List<Order> findAllWithMember(Long memberNumber);

    Optional<Order> findByOrderIdAndMemberNumber(Long orderId, Long memberNumber);
}

