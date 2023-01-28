package com.tme.userservice.application.service

import com.tme.userservice.application.converter.toUser
import com.tme.userservice.application.dto.UserJoinCommand
import com.tme.userservice.application.port.`in`.UserJoinUseCase
import com.tme.userservice.application.port.out.UserJoinPort
import com.tme.userservice.domain.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserJoinService(
    private val passwordEncoder: BCryptPasswordEncoder,
    private val userJoinPort: UserJoinPort
) : UserJoinUseCase {

    override fun join(command: UserJoinCommand): User {
        val user = toUser(command)
        user.changePassword(passwordEncoder.encode(user.password))
        return userJoinPort.save(user)
    }
}