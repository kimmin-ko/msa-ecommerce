package com.tme.userservice.adapters.out.persistence.entity

import javax.persistence.*

@Table(name = "users")
@Entity
class UserEntity(

    @Column(name = "email", length = 30, nullable = false)
    val email: String,

    @Column(name = "name", length = 20, nullable = false)
    var name: String,

    @Column(name = "user_id", length = 50, nullable = false)
    val userId: String,

    @Column(name = "password", length = 100, nullable = false)
    val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

) : BaseTimeEntity() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserEntity) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}