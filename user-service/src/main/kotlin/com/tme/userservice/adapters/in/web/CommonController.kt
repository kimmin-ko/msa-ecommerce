package com.tme.userservice.adapters.`in`.web

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonController(
    private val env: Environment
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