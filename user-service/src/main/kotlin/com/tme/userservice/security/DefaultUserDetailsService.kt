package com.tme.userservice.security

import com.tme.userservice.adapters.out.persistence.repository.UserRepository
import com.tme.userservice.util.invalidParam
import com.tme.userservice.util.notFound
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class DefaultUserDetailsService(
    private val repository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val email = username ?: invalidParam("Username must not be null")
        val userEntity = repository.findByEmail(email) ?: notFound(User::class.java)
        return DefaultUserDetails(userEntity.email, userEntity.password)
    }

}