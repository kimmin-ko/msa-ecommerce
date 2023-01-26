package com.tme.orderservice.domain.order

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "orders")
@Entity
class Order private constructor(

    @Column(nullable = false)
    val productId: Long,

    @Column(nullable = false)
    val quantity: Int,

    @Column(nullable = false)
    val unitPrice: Int,

    @Column(nullable = false)
    val totalPrice: Int,

    @Column(nullable = false)
    val userId: String,

    @Column(nullable = false, unique = true)
    val orderId: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

) {


}