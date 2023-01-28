package com.tme.userservice.adapters.`in`.web

import com.tme.userservice.adapters.`in`.web.converter.toJoinUserDto
import com.tme.userservice.adapters.`in`.web.converter.toUserJoinResponse
import com.tme.userservice.adapters.`in`.web.converter.toUserResponse
import com.tme.userservice.adapters.`in`.web.dto.CommonResponse
import com.tme.userservice.adapters.`in`.web.dto.UserJoinRequest
import com.tme.userservice.adapters.`in`.web.dto.UserJoinResponse
import com.tme.userservice.adapters.`in`.web.dto.UserResponse
import com.tme.userservice.application.port.`in`.UserJoinUseCase
import com.tme.userservice.application.port.`in`.UserLoadUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping
@RestController
class UserController(
    private val userJoinUseCase: UserJoinUseCase,
    private val userLoadUseCase: UserLoadUseCase,
) {

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody req: UserJoinRequest): CommonResponse<UserJoinResponse> {
        val user = userJoinUseCase.join(toJoinUserDto(req))
        return CommonResponse.withBody(toUserJoinResponse(user))
    }

    @GetMapping("/users/{userId}")
    fun getByUserId(@PathVariable userId: String): CommonResponse<UserResponse> {
        val user = userLoadUseCase.getByUserId(userId)
        return CommonResponse.withBody(toUserResponse(user))
    }

    @GetMapping("/users")
    fun getUsers(): CommonResponse<List<UserResponse>> {
        val userResponses = userLoadUseCase.findAll().map { user -> toUserResponse(user) }
        return CommonResponse.withBody(userResponses)
    }

}