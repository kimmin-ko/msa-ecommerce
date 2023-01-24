package com.tme.userservice.adapters.`in`.web.dto

data class UserResponse(
    val email: String,
    val name: String,
    val userId: String,
    val orders: List<OrderResponse>
)
