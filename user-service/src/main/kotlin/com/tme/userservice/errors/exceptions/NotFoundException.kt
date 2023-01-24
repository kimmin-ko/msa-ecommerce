package com.tme.userservice.errors.exceptions

import com.tme.userservice.errors.ErrorCode

class NotFoundException(
    errorMessage: String
) : BusinessException(
    errorCode = ErrorCode.NOT_FOUND,
    errorMessage = errorMessage
)