package com.peterson.pdv.domain.model.sale;

import com.peterson.pdv.domain.model.itemSale.ItemSale;
import com.peterson.pdv.domain.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="db_sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="sale_id")
    private Long id;

    @Column (name="sale_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    @OneToMany (mappedBy = "sale")
    private List<ItemSale> items;




}