package com.tme.userservice.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class DefaultUserDetails(
    private val email: String,
    private val password: String,
    private val authorities: MutableCollection<out GrantedAuthority> = mutableListOf()
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = this.authorities

    override fun getPassword(): String = this.password

    override fun getUsername(): String = this.email

    fun getEmail(): String = this.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

}