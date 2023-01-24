package com.tme.productservice.domain.product.dto.service;

import lombok.Getter;

@Getter
public class ProductDto {
    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;
    private String userId;
}
