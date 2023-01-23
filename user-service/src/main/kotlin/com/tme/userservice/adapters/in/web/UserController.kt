package com.tme.userservice.adapters.`in`.web

import com.tme.userservice.adapters.`in`.web.converter.toJoinUserDto
import com.tme.userservice.adapters.`in`.web.converter.toUserJoinResponse
import com.tme.userservice.adapters.`in`.web.dto.UserJoinRequest
import com.tme.userservice.adapters.`in`.web.dto.UserJoinResponse
import com.tme.userservice.application.service.UserJoinService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun createUser(@RequestBody req: UserJoinRequest): ResponseEntity<UserJoinResponse> {
        val user = userJoinService.join(toJoinUserDto(req))
        return ResponseEntity.status(HttpStatus.CREATED).body(toUserJoinResponse(user))
    }



}