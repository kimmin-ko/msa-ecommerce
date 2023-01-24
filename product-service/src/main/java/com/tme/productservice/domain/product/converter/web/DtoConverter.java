package com.tme.productservice.domain.product.converter.web;

import com.tme.productservice.domain.product.Product;
import com.tme.productservice.domain.product.dto.web.ProductResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DtoConverter {

    public static ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getProductName(),
                product.getUnitPrice(),
                product.getStock(),
                product.getCreatedAt()
        );
    }


}
