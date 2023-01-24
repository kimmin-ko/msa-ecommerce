package com.tme.userservice.adapters.`in`.web.converter

import com.tme.userservice.adapters.`in`.web.dto.UserJoinRequest
import com.tme.userservice.adapters.`in`.web.dto.UserJoinResponse
import com.tme.userservice.adapters.`in`.web.dto.UserResponse
import com.tme.userservice.application.dto.JoinUserDto
import com.tme.userservice.domain.User

fun toJoinUserDto(request: UserJoinRequest): JoinUserDto {
    return JoinUserDto(
        request.email,
        request.name,
        request.password
    )
}

fun toUserJoinResponse(user: User): UserJoinResponse {
    return UserJoinResponse(
        user.email,
        user.name,
        user.userId
    )
}

fun toUserResponse(user: User): UserResponse {
    return UserResponse(
        email = user.email,
        name = user.name,
        userId = user.userId,
        orders = listOf()
    )
}