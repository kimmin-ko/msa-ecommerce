package com.tme.userservice.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.tme.userservice.application.port.`in`.UserLoadUseCase
import com.tme.userservice.properties.JwtProps
import com.tme.userservice.util.invalidParam
import com.tme.userservice.util.logger
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.slf4j.Logger
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.Date
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(
    private val userLoadUseCase: UserLoadUseCase,
    private val jwtProps: JwtProps
) : UsernamePasswordAuthenticationFilter() {

    private val log: Logger = logger()

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val inputStream = request?.inputStream ?: invalidParam("An invalid request was passed.")
        val userLoginRequest = ObjectMapper().readValue(inputStream, UserLoginRequest::class.java)
        val token = UsernamePasswordAuthenticationToken(userLoginRequest.email, userLoginRequest.password, listOf())
        return authenticationManager.authenticate(token)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        val principal = authResult?.principal
        if (principal is DefaultUserDetails) {
            val userDetails: DefaultUserDetails = principal
            val user = userLoadUseCase.getByEmail(userDetails.username)

            val jwt = Jwts.builder()
                .setSubject(user.userId)
                .setExpiration(Date(System.currentTimeMillis() + jwtProps.expirationTime))
                .signWith(SignatureAlgorithm.HS512, jwtProps.secret)
                .compact()

            response?.addHeader("token", jwt)
            response?.addHeader("userId", user.userId)
        }
    }
}