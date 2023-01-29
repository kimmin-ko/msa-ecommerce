package com.tme.userservice.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class UserTest {

    @Test
    @DisplayName("유저가 정상적으로 생성된다.")
    fun create_test() {
        // given
        val email = "min@naver.com"
        val name = "min"
        val password = "test1234"

        // when
        val user = User.fixture(
            email = email,
            name = name,
            password = password
        )

        // then
        assertThat(user.id).isNull()
        assertThat(user.email).isEqualTo(email)
        assertThat(user.name).isEqualTo(name)
        assertThat(user.password).isEqualTo(password)
        assertThat(user.userId).isNotNull
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "a@b:Email not be less than 5 characters.",
            "minnavercom:Email must contain '@' characters."
        ],
        delimiter = ':'
    )
    @DisplayName("이메일은 5글자 이상이어야 하며 '@'가 포함되어야 합니다.")
    fun invalid_email_test(invalidEmail: String, errorMessage: String) {
        // given
        val name = "min"
        val password = "test1234"

        // when & then
        assertThatThrownBy {
            User.fixture(
                email = invalidEmail,
                name = name,
                password = password
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(errorMessage)
    }

    @ParameterizedTest
    @CsvSource(value = ["''", "' '"])
    @DisplayName("암호화된 비밀번호는 1글자 이상이어야 합니다. ")
    fun invalid_password_test(invalidPassword: String) {
        // given
        val email = "min@naver.com"
        val name = "min"

        // when & then
        assertThatThrownBy {
            User.fixture(
                email = email,
                name = name,
                password = invalidPassword
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Password must not be empty.")
    }

    @ParameterizedTest
    @CsvSource(value = ["''", "' '"])
    @DisplayName("회원 이름은 1글자 이상이어야 합니다. ")
    fun invalid_name_test(invalidName: String) {
        // given
        val email = "min@naver.com"
        val password = "test1234"

        // when & then
        assertThatThrownBy {
            User.fixture(
                email = email,
                name = invalidName,
                password = password
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Name must not be empty.")
    }

}