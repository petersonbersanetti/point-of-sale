package com.peterson.pdv.domain.model.itemSale;

import com.peterson.pdv.domain.model.product.Product;
import com.peterson.pdv.domain.model.sale.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="db_item_sale")
public class ItemSale {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="item_sale_id")
    private Long id;

    @ManyToOne
    @JoinColumn (name="sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn (name="product_id")
    private Product product;

    @Column (name="item_sale_quantity")
    private int quantity;


    
}
