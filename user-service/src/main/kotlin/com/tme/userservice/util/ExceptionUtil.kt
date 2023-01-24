package com.tme.userservice.util

import com.tme.userservice.errors.exceptions.NotFoundException

fun nfe(type: Class<*>): Nothing {
    throw NotFoundException("The ${type.simpleName} was not found.")
}