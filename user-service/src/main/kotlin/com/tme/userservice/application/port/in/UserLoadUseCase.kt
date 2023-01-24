package com.tme.userservice.application.port.`in`

import com.tme.userservice.domain.User

interface UserLoadUseCase {

    fun findByUserId(userId: String): User?

    fun getByUserId(userId: String): User

    fun findAll(): List<User>

}