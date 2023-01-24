package com.tme.userservice.adapters.`in`.web.dto

import java.time.LocalDateTime

class OrderResponse(
    val productId: String,
    val quantity: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDateTime,
    val orderId: String
)
