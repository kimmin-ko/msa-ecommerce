package com.tme.orderservice.domain.order

import com.tme.orderservice.common.entity.BaseTimeEntity
import java.lang.IllegalArgumentException
import java.util.*
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
    val productId: String,

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

) : BaseTimeEntity() {

    init {
        verifyProductId(productId)
        verifyQuantity(quantity)
        verifyUnitPrice(unitPrice)
        verifyUserId(userId)
    }

    companion object {
        @JvmStatic
        fun of(productId: String, quantity: Int, unitPrice: Int, userId: String): Order {
            return Order(
                productId = productId,
                quantity = quantity,
                unitPrice = unitPrice,
                totalPrice = unitPrice * quantity,
                userId = userId,
                orderId = UUID.randomUUID().toString()
            )
        }
    }

    private fun verifyUserId(userId: String) {
        if (userId.isBlank()) {
            throw IllegalArgumentException("User id must not be empty.")
        }
    }

    private fun verifyUnitPrice(unitPrice: Int) {
        if (unitPrice < 0) {
            throw IllegalArgumentException("Unit price not be less than 0.")
        }
    }

    private fun verifyQuantity(quantity: Int) {
        if (quantity < 1) {
            throw IllegalArgumentException("Order quantity not be less than 1.")
        }
    }

    private fun verifyProductId(productId: String) {
        if (productId.isBlank()) {
            throw IllegalArgumentException("Product id must not be empty.")
        }
    }

}