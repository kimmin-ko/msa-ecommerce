package com.tme.userservice.application.port.`in`

import com.tme.userservice.application.dto.UserJoinCommand
import com.tme.userservice.domain.User

interface UserJoinUseCase {

    fun join(command: UserJoinCommand): User
}