package com.tme.userservice.errors

class NotFoundException(
    errorMessage: String
) : BusinessException(
    errorCode = ErrorCode.NOT_FOUND,
    errorMessage = errorMessage
)