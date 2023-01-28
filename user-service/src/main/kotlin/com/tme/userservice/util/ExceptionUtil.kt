package com.tme.userservice.util

import com.tme.userservice.errors.exceptions.NotFoundException
import java.lang.IllegalArgumentException

fun notFound(type: Class<*>): Nothing {
    throw NotFoundException("The ${type.simpleName} was not found.")
}

fun invalidParam(message: String): Nothing {
    throw IllegalArgumentException(message)
}
