package com.tme.orderservice.domain.order

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {

    fun findByOrderId(orderId: String): Order?

    fun findAllByUserId(userId: String): List<Order>
}