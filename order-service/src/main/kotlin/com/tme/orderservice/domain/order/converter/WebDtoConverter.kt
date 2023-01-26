package com.tme.orderservice.domain.order.converter

import com.tme.orderservice.domain.order.dto.service.CreateOrderResult
import com.tme.orderservice.domain.order.dto.service.OrderDto
import com.tme.orderservice.domain.order.dto.web.CreateOrderResponse
import com.tme.orderservice.domain.order.dto.web.OrderResponse

fun resultToCreateOrderResponse(result: CreateOrderResult): CreateOrderResponse {
    return CreateOrderResponse(
        orderId = result.orderId,
        productId = result.productId,
        quantity = result.quantity,
        unitPrice = result.unitPrice,
        totalPrice = result.totalPrice,
        createdAt = result.createdAt
    )
}

fun dtoToOrderResponse(orderDto: OrderDto): OrderResponse {
    return OrderResponse(
        orderId = orderDto.orderId,
        productId = orderDto.productId,
        quantity = orderDto.quantity,
        unitPrice = orderDto.unitPrice,
        totalPrice = orderDto.totalPrice,
        createdAt = orderDto.createdAt
    )
}