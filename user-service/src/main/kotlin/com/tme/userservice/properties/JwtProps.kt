package com.tme.userservice.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "token")
class JwtProps(
    val expirationTime: Long,
    val secret: String
)