package com.tme.userservice.adapters.`in`.web

import com.tme.userservice.properties.Greeting
import com.tme.userservice.util.logger
import org.slf4j.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    val greeting: Greeting
) {

    private val log: Logger = logger()

//    @PostMapping
//    fun createUser(@RequestBody req: RequestUser): String {
//
//    }

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