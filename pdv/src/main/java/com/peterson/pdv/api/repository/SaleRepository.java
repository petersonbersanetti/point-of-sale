package com.peterson.pdv.api.repository;

import com.peterson.pdv.domain.model.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository <Sale, Long> {
}
