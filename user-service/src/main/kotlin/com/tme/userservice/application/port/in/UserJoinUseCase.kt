package com.tme.userservice.application.port.`in`

import com.tme.userservice.application.dto.JoinUserDto
import com.tme.userservice.domain.User

interface UserJoinUseCase {

    fun join(joinUserDto: JoinUserDto): User
}