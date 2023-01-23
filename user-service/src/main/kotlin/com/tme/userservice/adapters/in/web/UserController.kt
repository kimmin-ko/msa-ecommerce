package com.tme.userservice.adapters.`in`.web

import com.tme.userservice.adapters.`in`.web.converter.toJoinUserDto
import com.tme.userservice.adapters.`in`.web.dto.UserJoinRequest
import com.tme.userservice.application.service.UserJoinService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping
@RestController
class UserController(
    private val userJoinService: UserJoinService
) {

    @PostMapping("/users")
    fun createUser(@RequestBody req: UserJoinRequest): String {
        userJoinService.join(toJoinUserDto(req))
        return "Create user method is called."
    }

}