package com.tme.orderservice.domain.order.dto.web

data class CreateOrderRequest(
    val productId: String,
    val quantity: Int,
    val unitPrice: Int
)