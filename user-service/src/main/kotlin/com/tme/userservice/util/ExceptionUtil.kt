package com.tme.userservice.util

import com.tme.userservice.errors.NotFoundException

fun nfe(type: Class<*>): Nothing {
    throw NotFoundException("The $type.simpleName was not found.")
}