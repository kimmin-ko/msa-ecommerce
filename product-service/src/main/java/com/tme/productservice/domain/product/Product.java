package com.tme.productservice.domain.product;

import com.tme.productservice.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer unitPrice;

    // constructor //
    private Product(String productName, Integer stock, Integer unitPrice) {
        this.productId = UUID.randomUUID().toString();
        this.productName = verifyProductName(productName);
        this.stock = verifyStock(stock);
        this.unitPrice = verifyUnitPrice(unitPrice);
    }

    // static factory method //
    public static Product fixture(String productName, Integer stock, Integer unitPrice) {
        return new Product(productName, stock, unitPrice);
    }

    // associate //

    // change //

    // getter //

    // functional //

    // private //


}
