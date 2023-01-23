package com.tme.userservice.application.converter

import com.tme.userservice.application.dto.JoinUserDto
import com.tme.userservice.domain.User

fun toUser(joinUserDto: JoinUserDto): User {
    return User(
        email = joinUserDto.email,
        name = joinUserDto.name,
        password = joinUserDto.password
    )
}