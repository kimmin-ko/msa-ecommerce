package com.tme.orderservice.domain.order.dto.web

import java.time.LocalDateTime

data class OrderResponse(
    val orderId: String,
    val productId: String,
    val quantity: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDateTime
)