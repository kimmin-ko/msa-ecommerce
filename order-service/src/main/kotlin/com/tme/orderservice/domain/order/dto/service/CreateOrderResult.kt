package com.tme.orderservice.domain.order.dto.service

import java.time.LocalDateTime

data class CreateOrderResult(
    val orderId: String,
    val productId: String,
    val userId: String,
    val quantity: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDateTime
)
