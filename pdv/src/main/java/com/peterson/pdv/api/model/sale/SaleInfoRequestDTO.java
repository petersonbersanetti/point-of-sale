package com.peterson.pdv.api.model.sale;

import com.peterson.pdv.api.model.product.ProductInfoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleInfoRequestDTO {

    private String user;
    private String date;
    private List<ProductInfoRequestDTO> products;

}
