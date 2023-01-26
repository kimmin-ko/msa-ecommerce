package com.tme.orderservice.common.response

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.domain.Page

@JsonInclude(JsonInclude.Include.NON_NULL)
class CommonResponse<T> private constructor(
    val code: Int = SUCCESS_CODE,
    val body: T? = null,
    val pagination: Pagination? = null,
) {

    companion object {
        const val SUCCESS_CODE = 0

        @JvmStatic
        fun <T> emptyBody(): CommonResponse<T> {
            return CommonResponse()
        }

        @JvmStatic
        fun <T> withBody(body: T): CommonResponse<T> {
            return CommonResponse(body = body)
        }

        @JvmStatic
        fun <T> withPage(body: T, page: Page<*>): CommonResponse<T> {
            return CommonResponse(body = body, pagination = Pagination(page))
        }
    }

}

class Pagination(page: Page<*>) {
    val totalCount: Long = page.totalElements
    val totalPage: Int = page.totalPages
    val hasPrevious: Boolean = page.hasPrevious()
    val hasNext: Boolean = page.hasNext()
    val pageNumber: Int = page.number
}