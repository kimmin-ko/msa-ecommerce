package com.tme.userservice.adapters.`in`.web

import com.tme.userservice.properties.JwtProps
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonController(
    private val env: Environment,
    private val jwtProps: JwtProps
) {

    @GetMapping("/health-check")
    fun status(): String {
        return """It's working in user service
            , port(local.server.port) = ${env.getProperty("local.server.port")}
            , port(server.port) = ${env.getProperty("server.port")}
            , token secret = ${env.getProperty("token.secret")}
            , token expiration time = ${env.getProperty("token.expiration-time")}
        """.trimIndent()
    }
}