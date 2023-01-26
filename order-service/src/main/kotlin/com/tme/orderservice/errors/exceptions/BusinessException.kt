package com.tme.orderservice.errors.exceptions

import com.tme.orderservice.errors.ErrorCode

abstract class BusinessException(
    val errorCode: ErrorCode,
    val errorMessage: String
) : RuntimeException()