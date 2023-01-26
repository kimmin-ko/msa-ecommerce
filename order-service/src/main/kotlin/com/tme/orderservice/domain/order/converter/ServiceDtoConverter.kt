package com.tme.orderservice.domain.order.converter

import com.tme.orderservice.domain.order.Order
import com.tme.orderservice.domain.order.dto.service.CreateOrderCommand
import com.tme.orderservice.domain.order.dto.service.CreateOrderResult
import com.tme.orderservice.domain.order.dto.service.OrderDto
import com.tme.orderservice.domain.order.dto.web.CreateOrderRequest

// entity //
fun entityToCreateOrderResult(order: Order): CreateOrderResult {
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

fun entityToOrderDto(order: Order): OrderDto {
    return OrderDto(
        orderId = order.orderId,
        productId = order.productId,
        userId = order.userId,
        quantity = order.quantity,
        unitPrice = order.unitPrice,
        totalPrice = order.totalPrice,
        createdAt = order.createdAt!!
    )
}

// web //
fun requestToCreateOrderCommand(request: CreateOrderRequest, userId: String): CreateOrderCommand {
    return CreateOrderCommand(
        productId = request.productId,
        userId = userId,
        quantity = request.quantity,
        unitPrice = request.unitPrice
    )
}