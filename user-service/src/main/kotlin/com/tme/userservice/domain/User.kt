package com.tme.userservice.domain

import java.lang.IllegalArgumentException
import java.util.*

class User(
    val email: String,
    var name: String,
    var password: String,
    val userId: String = UUID.randomUUID().toString(),
    var id: Long? = null,
) {

    init {
        checkEmail(email)
        checkName(name)
        checkPassword(password)
    }

    // change //
    fun changeName(name: String) {
        checkName(name)
        this.name = name
    }

    fun changePassword(password: String) {
        checkPassword(password)
        this.password = password
    }

    // check //
    private fun checkName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name must not be empty.")
        }
    }

    private fun checkPassword(password: String) {
        if (password.isBlank()) {
            throw IllegalArgumentException("Password must not be empty.")
        }
    }

    private fun checkEmail(email: String) {
        if (email.length < 5) {
            throw IllegalArgumentException("Email not be less than 5 characters.")
        } else if (!email.contains("@")) {
            throw IllegalArgumentException("Email must contain '@' characters.")
        }
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
        return "User(id=$id, email='$email', name='$name', password='$password', userId='$userId')"
    }

}