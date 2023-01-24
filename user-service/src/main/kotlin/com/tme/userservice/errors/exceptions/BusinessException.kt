package com.tme.userservice.errors.exceptions

import com.tme.userservice.errors.ErrorCode

abstract class BusinessException(
    val errorCode: ErrorCode,
    val errorMessage: String
) : RuntimeException()