package com.tme.orderservice.domain.order

import com.tme.orderservice.common.response.CommonResponse
import com.tme.orderservice.domain.order.converter.dtoToOrderResponse
import com.tme.orderservice.domain.order.converter.requestToCreateOrderCommand
import com.tme.orderservice.domain.order.converter.resultToCreateOrderResponse
import com.tme.orderservice.domain.order.dto.web.CreateOrderRequest
import com.tme.orderservice.domain.order.dto.web.CreateOrderResponse
import com.tme.orderservice.domain.order.dto.web.OrderResponse
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/order-service")
@RestController
class OrderController(
    private val env: Environment,
    private val service: OrderService,
    private val queryService: OrderQueryService,
) {

    @PostMapping("/users/{userId}/orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(
        @PathVariable userId: String,
        @RequestBody req: CreateOrderRequest
    ): CommonResponse<CreateOrderResponse> {
        val command = requestToCreateOrderCommand(req, userId)
        val result = service.createOrder(command)
        val response = resultToCreateOrderResponse(result)
        return CommonResponse.withBody(response)
    }

    @GetMapping("/users/{userId}/orders")
    fun getOrders(@PathVariable userId: String): CommonResponse<List<OrderResponse>> {
        val orderDtos = queryService.findAllByUserId(userId)
        val responses = orderDtos.map { orderDto -> dtoToOrderResponse(orderDto) }
        return CommonResponse.withBody(responses)
    }

    @GetMapping("/health-check")
    fun status(): String {
        return "It's working in order service on port ${env.getProperty("local.server.port")}"
    }

}