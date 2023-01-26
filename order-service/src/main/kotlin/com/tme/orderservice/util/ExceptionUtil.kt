package com.tme.orderservice.util

import com.tme.orderservice.errors.exceptions.NotFoundException

fun nfe(type: Class<*>): Nothing {
    throw NotFoundException("The ${type.simpleName} was not found.")
}