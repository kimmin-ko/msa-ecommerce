package com.tme.userservice.application.service

import com.tme.userservice.application.port.`in`.UserLoadUseCase
import com.tme.userservice.application.port.out.UserLoadPort
import com.tme.userservice.domain.User
import com.tme.userservice.util.notFound
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
        return findByUserId(userId) ?: notFound(User::class.java)
    }

    override fun findByEmail(email: String): User? {
        return userLoadPort.findByEmail(email)
    }

    override fun getByEmail(email: String): User {
        return findByEmail(email) ?: notFound(User::class.java)
    }

    @Deprecated("refactor pagination")
    override fun findAll(): List<User> {
        return userLoadPort.findAll()
    }


}