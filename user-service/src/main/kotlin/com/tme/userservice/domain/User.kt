package com.tme.userservice.domain

import javax.persistence.*

@Table(name = "users")
@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private val id: Long



)