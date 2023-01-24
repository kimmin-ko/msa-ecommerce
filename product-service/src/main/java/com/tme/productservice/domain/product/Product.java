package com.tme.productservice.domain.product;

import com.tme.productservice.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString(exclude = {})
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

    // static factory method //

    // associate //

    // change //

    // getter //

    // functional //

    // private //


}
