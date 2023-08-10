package com.peterson.pdv.api.model.sale;

import com.peterson.pdv.api.model.product.ProductRequestDTO;
import com.peterson.pdv.domain.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequestDTO {

    private long userid;

    List<ProductRequestDTO> items;

}