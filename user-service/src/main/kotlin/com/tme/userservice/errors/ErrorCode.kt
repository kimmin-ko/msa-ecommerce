package com.tme.userservice.errors

enum class ErrorCode(
    val code: Int,
    val defaultMessage: String
) {

    // COMMON
    NOT_FOUND(1004, "The resource was not found.")

}