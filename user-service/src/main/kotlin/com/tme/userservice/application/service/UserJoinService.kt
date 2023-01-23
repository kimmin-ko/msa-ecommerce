package com.tme.userservice.application.service

import com.tme.userservice.application.converter.toUser
import com.tme.userservice.application.dto.JoinUserDto
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

    override fun join(joinUserDto: JoinUserDto): User {
        val user = toUser(joinUserDto)
        user.changePassword(passwordEncoder.encode(user.password))
        userJoinPort.save(user)
        return user
    }
}