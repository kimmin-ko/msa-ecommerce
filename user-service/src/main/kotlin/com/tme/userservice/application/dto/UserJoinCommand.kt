package com.tme.userservice.application.dto

data class UserJoinCommand(
    val email: String,
    val name: String,
    val password: String
)