package com.peterson.pdv.api.repository;

import com.peterson.pdv.domain.model.itemSale.ItemSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSaleRepository extends JpaRepository<ItemSale, Long> {
}
