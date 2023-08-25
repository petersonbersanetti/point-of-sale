package com.peterson.pdv.api.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoRequestDTO {

    private String description;
    private int quantity;
}
