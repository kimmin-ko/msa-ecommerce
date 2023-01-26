package com.tme.orderservice.domain.order

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class OrderQueryService(
    private val repository: OrderRepository
) {

    

}