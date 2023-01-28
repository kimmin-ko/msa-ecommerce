package com.tme.userservice.security

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class UserLoginRequest {

    @NotNull(message = "Email must not be null")
    @Email(message = "It is not an email format")
    var email: String? = null

    @NotNull(message = "Password must not be null")
    @Size(min = 8, message = "Password must be equal or grater than 8 characters")
    var password: String? = null

}