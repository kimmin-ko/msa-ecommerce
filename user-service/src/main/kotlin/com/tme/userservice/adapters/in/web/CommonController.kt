package com.tme.userservice.adapters.`in`.web

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CommonController(
    private val env: Environment
) {

    @GetMapping("/user-service/health-check")
    fun status(): String {
        return "It's working in user service on port ${env.getProperty("local.server.port")}"
    }
}