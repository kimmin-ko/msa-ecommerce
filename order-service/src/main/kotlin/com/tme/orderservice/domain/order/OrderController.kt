package com.tme.orderservice.domain.order

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/order-service")
@RestController
class OrderController(
    private val queryService: OrderQueryService,
) {



}