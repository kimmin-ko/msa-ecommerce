package com.tme.productservice.domain.product;

import com.tme.productservice.common.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.util.Assert;

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
    private int stock;

    @Column(nullable = false)
    private int unitPrice;

    // constructor //
    public Product(String productName, int stock, int unitPrice) {
        verifyProductName(productName);
        verifyStock(stock);
        verifyUnitPrice(unitPrice);

        this.productId = UUID.randomUUID().toString();
        this.productName = productName;
        this.stock = stock;
        this.unitPrice = unitPrice;
    }

    // static factory method //
    public static Product fixture(String productName, int stock, int unitPrice) {
        return new Product(productName, stock, unitPrice);
    }

    // associate //

    // change //

    // getter //

    // functional //

    // private //
    private void verifyUnitPrice(int unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Product unit price must be equal or grater than 1.");
        }
    }

    private void verifyStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Product stock must be equal or grater than 1.");
        }
    }

    private void verifyProductName(String productName) {
        Assert.notNull(productName, "Product name must not be null.");

        if (productName.isBlank()) {
            throw new IllegalArgumentException("Product name must not be empty.");
        }
    }

}
