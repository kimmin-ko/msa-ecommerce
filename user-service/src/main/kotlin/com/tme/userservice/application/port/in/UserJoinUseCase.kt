package com.tme.userservice.application.port.`in`

import com.tme.userservice.application.dto.JoinUserDto

interface UserJoinUseCase {

    fun join(joinUserDto: JoinUserDto)
}