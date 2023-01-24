package com.tme.userservice.adapters.out.persistence

import com.tme.userservice.adapters.out.persistence.converter.toUser
import com.tme.userservice.adapters.out.persistence.repository.UserRepository
import com.tme.userservice.application.port.out.UserLoadPort
import com.tme.userservice.domain.User
import org.springframework.stereotype.Repository

@Repository
class UserLoadAdapter(
    private val userRepository: UserRepository
) : UserLoadPort {

    override fun findByUserId(userId: String): User? {
        val userEntity = userRepository.findByUserId(userId) ?: return null
        return toUser(userEntity)
    }

    override fun findAll(): List<User> {
        return userRepository.findAll().map { userEntity -> toUser(userEntity) }
    }

}