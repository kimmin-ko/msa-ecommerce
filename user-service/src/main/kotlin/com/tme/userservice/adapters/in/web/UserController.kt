package com.tme.userservice.adapters.`in`.web

import com.tme.userservice.adapters.`in`.web.converter.toJoinUserDto
import com.tme.userservice.adapters.`in`.web.converter.toUserJoinResponse
import com.tme.userservice.adapters.`in`.web.dto.CommonResponse
import com.tme.userservice.adapters.`in`.web.dto.UserJoinRequest
import com.tme.userservice.adapters.`in`.web.dto.UserJoinResponse
import com.tme.userservice.application.service.UserJoinService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/user-service")
@RestController
class UserController(
    private val userJoinService: UserJoinService
) {

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody req: UserJoinRequest): CommonResponse<UserJoinResponse> {
        val user = userJoinService.join(toJoinUserDto(req))
        return CommonResponse.withBody(toUserJoinResponse(user))
    }

}