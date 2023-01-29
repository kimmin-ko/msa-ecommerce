package com.tme.userservice.domain

import java.util.*

class User(
    val email: String,
    var name: String,
    var password: String,
    val userId: String = UUID.randomUUID().toString(),
    var id: Long? = null
) {

    init {
        verifyEmail(email)
        verifyName(name)
        verifyPassword(password)
    }

    companion object {
        @JvmStatic
        fun fixture(email: String, name: String, password: String): User {
            return User(
                email = email,
                name = name,
                password = password
            )
        }
    }

    // change //
    fun changeName(name: String) {
        verifyName(name)
        this.name = name
    }

    fun changePassword(password: String) {
        verifyPassword(password)
        this.password = password
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "User(email='$email', name='$name', password='$password', userId='$userId', id=$id)"
    }

    // private //
    private fun verifyName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name must not be empty.")
        }
    }

    private fun verifyPassword(password: String) {
        if (password.isBlank()) {
            throw IllegalArgumentException("Password must not be empty.")
        }
    }

    private fun verifyEmail(email: String) {
        if (email.length < 5) {
            throw IllegalArgumentException("Email not be less than 5 characters.")
        } else if (!email.contains("@")) {
            throw IllegalArgumentException("Email must contain '@' characters.")
        }
    }
}