package com.tme.userservice.domain.user

import com.tme.userservice.properties.Greeting
import com.tme.userservice.util.logger
import org.slf4j.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class UserController(
    val greeting: Greeting
) {

    private val log: Logger = logger()

    @GetMapping("/health-check")
    fun status(): String {
        log.info("health-check")
        return "It's working in user service."
    }

    @GetMapping("/welcome")
    fun welcome(): String {
        return greeting.message
    }
}