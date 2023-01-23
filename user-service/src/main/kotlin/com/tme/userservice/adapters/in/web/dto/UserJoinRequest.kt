package com.tme.userservice.adapters.`in`.web.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UserJoinRequest(

    @Email
    @NotNull(message = "Email must not be null.")
    val email: String,

    @NotNull(message = "Name must not be null.")
    @Size(message = "Name not be less than 2 characters.")
    val name: String,

    @NotNull(message = "Password must not be null.")
    @Size(message = "Password must be equal or grater than 8 characters.")
    val password: String
)