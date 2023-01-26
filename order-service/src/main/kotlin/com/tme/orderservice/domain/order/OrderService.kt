package com.tme.orderservice.domain.order

import com.tme.orderservice.domain.order.converter.toCreateOrderResult
import com.tme.orderservice.domain.order.dto.service.CreateOrderCommand
import com.tme.orderservice.domain.order.dto.service.CreateOrderResult
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class OrderService(
    private val repository: OrderRepository
) {

    fun createOrder(command: CreateOrderCommand): CreateOrderResult {
        val order = Order.of(
            productId = command.productId,
            quantity = command.quantity,
            unitPrice = command.unitPrice,
            userId = command.userId
        )

        val savedOrder = repository.save(order)
        return toCreateOrderResult(savedOrder)
    }

}