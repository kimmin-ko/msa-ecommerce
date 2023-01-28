package com.tme.userservice.security

import com.tme.userservice.application.port.`in`.UserLoadUseCase
import com.tme.userservice.properties.JwtProps
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class WebSecurity(
    private val jwtProps: JwtProps,
    private val authenticationConfiguration: AuthenticationConfiguration,
    private val userLoadUseCase: UserLoadUseCase
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()

        // 인가
        http.authorizeRequests()
            .antMatchers("/**").permitAll()
            .antMatchers("/actuator/**").permitAll()
            .and()
            .addFilter(getAuthenticationFilter())

        // h2-console 화면을 보기 위한 설정
        http.headers().frameOptions().disable()
        return http.build()
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    private fun getAuthenticationFilter(): AuthenticationFilter {
        val authenticationFilter = AuthenticationFilter(userLoadUseCase, jwtProps)
        authenticationFilter.setAuthenticationManager(authenticationManager())
        return authenticationFilter
    }
}