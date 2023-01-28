package com.tme.apigatewayservice.filter

import com.tme.apigatewayservice.properties.JwtProps
import com.tme.apigatewayservice.util.logger
import io.jsonwebtoken.Jwts
import org.slf4j.Logger
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class AuthorizationHeaderFilter(
    private val jwtProps: JwtProps
) : AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>(Config::class.java) {

    private val log: Logger = logger()

    override fun apply(config: Config?): GatewayFilter {
        return GatewayFilter filter@{ exchange, chain ->
            val request: ServerHttpRequest = exchange.request

            if (!request.headers.containsKey(HttpHeaders.AUTHORIZATION)) {
                return@filter onError(exchange, "No authorization header.", HttpStatus.UNAUTHORIZED)
            }

            val authorizationHeader = request.headers[HttpHeaders.AUTHORIZATION]!![0]
            val jwt = authorizationHeader.replace("Bearer", "")

            if (!isJwtValid(jwt)) {
                return@filter onError(exchange, "Jwt is not valid.", HttpStatus.UNAUTHORIZED)
            }

            chain.filter(exchange)
        }
    }

    private fun isJwtValid(jwt: String): Boolean {
        return try {
            val subject = Jwts.parser()
                .setSigningKey(jwtProps.secret)
                .parseClaimsJws(jwt).body
                .subject

            if (subject == null || subject.isBlank()) {
                log.error("Subject must not be null.")
                return false
            }

            true
        } catch (e: Exception) {
            log.error(e.message)
            false
        }
    }

    private fun onError(exchange: ServerWebExchange, error: String, httpStatus: HttpStatus): Mono<Void> {
        val response = exchange.response
        response.statusCode = httpStatus

        log.error(error)
        return response.setComplete()
    }

    class Config

}