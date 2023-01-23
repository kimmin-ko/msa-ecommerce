package com.tme.userservice.adapters.`in`.web.converter

import com.tme.userservice.adapters.`in`.web.dto.UserJoinRequest
import com.tme.userservice.application.dto.JoinUserDto

fun toJoinUserDto(request: UserJoinRequest): JoinUserDto {
    return JoinUserDto(
        request.email,
        request.name,
        request.password
    )
}