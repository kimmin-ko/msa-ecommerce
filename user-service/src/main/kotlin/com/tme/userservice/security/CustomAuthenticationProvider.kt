package com.tme.userservice.security

import com.tme.userservice.util.logger
import org.slf4j.Logger
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class CustomAuthenticationProvider(
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val userDetailsService: DefaultUserDetailsService
) : AuthenticationProvider {

    private val log: Logger = logger()

    override fun authenticate(authentication: Authentication?): Authentication {
        val userDetails = userDetailsService.loadUserByUsername(authentication?.name)
        val password = authentication?.credentials.toString()
        log.info("username: ${userDetails.username}, law password: ${password}, encoded password: ${userDetails.password}")
        if (!bCryptPasswordEncoder.matches(password, userDetails.password)) {
            throw BadCredentialsException("Invalid password. username: ${userDetails.username}")
        }
        return UsernamePasswordAuthenticationToken(userDetails.username, userDetails.password, mutableListOf())
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication?.equals(UsernamePasswordAuthenticationToken::class) ?: false
    }
}