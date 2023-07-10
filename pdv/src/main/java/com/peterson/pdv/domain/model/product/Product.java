package com.peterson.pdv.domain.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="db_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="product_id")
    private Long id;

    @Column (name="product_description")
    private String description;

    @Column (name="product_price")
    private BigDecimal price;

    @Column (name="product_quantity")
    private int quantity;
}
