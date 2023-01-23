package com.tme.userservice.application.dto

data class JoinUserDto(
    val email: String,
    val name: String,
    val password: String
)