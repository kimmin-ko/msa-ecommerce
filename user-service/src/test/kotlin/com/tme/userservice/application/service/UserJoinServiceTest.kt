package com.tme.userservice.application.service

import com.tme.userservice.adapters.out.persistence.repository.UserRepository
import com.tme.userservice.application.dto.UserJoinCommand
import com.tme.userservice.application.port.`in`.UserJoinUseCase
import com.tme.userservice.domain.User
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest
class UserJoinServiceTest @Autowired constructor(
    private val passwordEncoder: BCryptPasswordEncoder,
    private val userJoinUseCase: UserJoinUseCase,
    private val userRepository: UserRepository,
) {

    @AfterEach
    fun cleanup() {
        println("--CLEANUP--")
        userRepository.deleteAll()
    }

    @Test
    @DisplayName("회원 가입이 정상 동작한다.")
    fun join_test() {
        // given
        val request = UserJoinCommand(
            email = "min@naver.com",
            name = "kim min",
            password = "test1234"
        )

        // when
        val savedUser: User = userJoinUseCase.join(request)

        // then
        assertThat(savedUser.id).isNotNull
        assertThat(savedUser.email).isEqualTo(request.email)
        assertThat(savedUser.name).isEqualTo(request.name)
        assertThat(passwordEncoder.matches(request.password, savedUser.password)).isTrue
    }

}