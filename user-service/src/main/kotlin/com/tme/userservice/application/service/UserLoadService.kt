package com.tme.userservice.application.service

import com.tme.userservice.application.port.`in`.UserLoadUseCase
import com.tme.userservice.application.port.out.UserLoadPort
import com.tme.userservice.domain.User
import com.tme.userservice.util.nfe
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class UserLoadService(
    private val userLoadPort: UserLoadPort
) : UserLoadUseCase {

    override fun findByUserId(userId: String): User? {
        return userLoadPort.findByUserId(userId)
    }

    override fun getByUserId(userId: String): User {
        return findByUserId(userId) ?: nfe(User::class.java)
    }

    @Deprecated("refactor pagination")
    override fun findAll(): List<User> {
        return userLoadPort.findAll()
    }

}