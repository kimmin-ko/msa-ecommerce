package com.tme.orderservice.errors.exceptions

import com.tme.orderservice.errors.ErrorCode

class NotFoundException(
    errorMessage: String
) : BusinessException(
    errorCode = ErrorCode.NOT_FOUND,
    errorMessage = errorMessage
)