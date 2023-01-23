package com.tme.userservice.application.port.out

import com.tme.userservice.domain.User

interface UserJoinPort {

    fun save(user: User)
}