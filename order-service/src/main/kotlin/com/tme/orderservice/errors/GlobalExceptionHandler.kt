package com.tme.orderservice.errors

import com.tme.orderservice.errors.exceptions.BusinessException
import com.tme.orderservice.util.logger
import org.slf4j.Logger
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun business(e: BusinessException): ErrorResponse {
        return ErrorResponse(e.errorCode.code, e.errorMessage)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgument(e: IllegalArgumentException): ErrorResponse {
        val errorCode = ErrorCode.INVALID_PARAMETER
        return ErrorResponse(errorCode.code, e.message ?: errorCode.defaultMessage)
    }

}