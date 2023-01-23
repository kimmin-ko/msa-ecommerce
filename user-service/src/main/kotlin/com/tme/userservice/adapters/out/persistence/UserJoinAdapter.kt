package com.tme.userservice.adapters.out.persistence

import com.tme.userservice.adapters.out.persistence.converter.toEntity
import com.tme.userservice.adapters.out.persistence.repository.UserRepository
import com.tme.userservice.application.port.out.UserJoinPort
import com.tme.userservice.domain.User
import org.springframework.stereotype.Repository

@Repository
class UserJoinAdapter(
    private val userRepository: UserRepository
) : UserJoinPort {

    override fun save(user: User) {
        userRepository.save(toEntity(user))
    }

}