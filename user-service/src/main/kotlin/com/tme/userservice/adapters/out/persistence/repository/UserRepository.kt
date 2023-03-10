package com.tme.userservice.adapters.out.persistence.repository

import com.tme.userservice.adapters.out.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUserId(userId: String): UserEntity?

    fun findByEmail(email: String?): UserEntity?

}