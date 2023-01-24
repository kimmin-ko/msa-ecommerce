package com.tme.userservice.adapters.out.persistence.converter

import com.tme.userservice.adapters.out.persistence.entity.UserEntity
import com.tme.userservice.domain.User

fun toEntity(user: User): UserEntity {
    return UserEntity(
        email = user.email,
        name = user.name,
        userId = user.userId,
        password = user.password
    )
}

fun toUser(userEntity: UserEntity): User {
    return User(
        email = userEntity.email,
        name = userEntity.name,
        password = userEntity.password,
        userId = userEntity.userId,
        id = userEntity.id
    )
}