package com.tme.orderservice.errors

data class ErrorResponse(
    val code: Int,
    val errorMessage: String
)