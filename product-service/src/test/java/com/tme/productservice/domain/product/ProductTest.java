package com.tme.productservice.domain.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductTest {

    @Test
    @DisplayName("상품을 정상적으로 생성한다.")
    void create_product_test() {
        // given
        String productName = "banana";
        int stock = 100;
        int unitPrice = 4500;

        // when
        Product product = Product.fixture(productName, stock, unitPrice);

        // then
        assertThat(product.getId()).isNull();
        assertThat(product.getProductId()).isNotNull();
        assertThat(product.getProductName()).isEqualTo(productName);
        assertThat(product.getStock()).isEqualTo(stock);
        assertThat(product.getUnitPrice()).isEqualTo(unitPrice);
    }

}