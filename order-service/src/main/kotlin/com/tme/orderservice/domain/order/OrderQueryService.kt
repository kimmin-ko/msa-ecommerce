package com.tme.orderservice.domain.order

import com.tme.orderservice.domain.order.converter.entityToOrderDto
import com.tme.orderservice.domain.order.dto.service.OrderDto
import com.tme.orderservice.util.nfe
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class OrderQueryService(
    private val repository: OrderRepository
) {

    fun findByOrderId(orderId: String): OrderDto? {
        val order = repository.findByOrderId(orderId) ?: return null
        return entityToOrderDto(order)
    }

    fun getByOrderId(orderId: String): OrderDto {
        return findByOrderId(orderId) ?: nfe(Order::class.java)
    }

    fun findAllByUserId(userId: String): List<OrderDto> {
        return repository.findAllByUserId(userId).map { order -> entityToOrderDto(order) }
    }

}