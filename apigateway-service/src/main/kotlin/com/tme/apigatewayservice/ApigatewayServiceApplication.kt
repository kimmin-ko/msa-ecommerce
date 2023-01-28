package com.tme.apigatewayservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class ApigatewayServiceApplication

fun main(args: Array<String>) {
    runApplication<ApigatewayServiceApplication>(*args)
}
