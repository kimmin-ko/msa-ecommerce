package com.tme.orderservice.domain.order.converter

import com.tme.orderservice.domain.order.Order
import com.tme.orderservice.domain.order.dto.service.CreateOrderResult

fun toCreateOrderResult(order: Order): CreateOrderResult {
    return CreateOrderResult(
        orderId = order.orderId,
        productId = order.productId,
        userId = order.userId,
        quantity = order.quantity,
        unitPrice = order.unitPrice,
        totalPrice = order.totalPrice,
        createdAt = order.createdAt!!
    )
}