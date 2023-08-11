package com.peterson.pdv.domain.service.sale;

import com.peterson.pdv.api.model.product.ProductRequestDTO;
import com.peterson.pdv.api.model.sale.SaleRequestDTO;
import com.peterson.pdv.api.repository.ItemSaleRepository;
import com.peterson.pdv.api.repository.ProductRepository;
import com.peterson.pdv.api.repository.SaleRepository;
import com.peterson.pdv.api.repository.UserRepository;
import com.peterson.pdv.domain.model.itemSale.ItemSale;
import com.peterson.pdv.domain.model.product.Product;
import com.peterson.pdv.domain.model.sale.Sale;
import com.peterson.pdv.domain.model.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final ItemSaleRepository itemSaleRepository;

    @Transactional
    public long save(SaleRequestDTO saleRequestDTO){
        User user = userRepository.findById(saleRequestDTO.getUserid()).get();

        Sale sale = new Sale();
        sale.setUser(user);
        sale.setDate(LocalDateTime.now());
        List<ItemSale> items = getItemSale(sale.getItems());

        sale = saleRepository.save(sale);

        saveItemSale(items, sale);

        return sale.getId();
    }

    @Transactional
    private void saveItemSale(List<ItemSale> items, Sale sale){
        for (ItemSale item:items){
            item.setSale(sale);
            itemSaleRepository.save(item);
        }

    }


    private List<ItemSale> getItemSale (List<ProductRequestDTO>  products){

        return products.stream().map(item -> {
            Product product = productRepository.getReferenceById(item.getProductid());

            ItemSale itemSale = new ItemSale();
            ItemSale.setProduct(product);
            ItemSale.setQuantity(item.getQuantity());

        return itemSale;
    }).collect(Collectors.toList());

}
