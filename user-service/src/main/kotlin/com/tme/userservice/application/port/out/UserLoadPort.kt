package com.tme.userservice.application.port.out

import com.tme.userservice.domain.User

interface UserLoadPort {

    fun findByUserId(userId: String): User?

    fun findAll(): List<User>

}