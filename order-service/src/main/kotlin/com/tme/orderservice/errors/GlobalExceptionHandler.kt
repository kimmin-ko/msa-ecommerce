package com.tme.orderservice.errors

import com.tme.orderservice.errors.exceptions.BusinessException
import com.tme.orderservice.util.logger
import org.slf4j.Logger
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log: Logger = logger()

    @ExceptionHandler(BusinessException::class)
    fun business(e: BusinessException): ErrorResponse {
        return ErrorResponse(e.errorCode.code, e.errorMessage)
    }

}