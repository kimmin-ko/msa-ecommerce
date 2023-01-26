package com.tme.orderservice.domain.order.dto.service

data class CreateOrderCommand(
    val orderId: String,
    val productId: String,
    val userId: String,
    val quantity: Int,
    val unitPrice: Int
)