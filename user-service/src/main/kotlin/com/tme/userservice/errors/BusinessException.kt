package com.tme.userservice.errors

abstract class BusinessException(
    private val errorCode: ErrorCode,
    private val errorMessage: String
) : RuntimeException()