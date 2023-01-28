package com.tme.userservice.application.converter

import com.tme.userservice.application.dto.UserJoinCommand
import com.tme.userservice.domain.User

fun toUser(command: UserJoinCommand): User {
    return User(
        email = command.email,
        name = command.name,
        password = command.password
    )
}