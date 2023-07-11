package com.peterson.pdv.domain.model.user;

import com.peterson.pdv.domain.model.sale.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="user_id")
    private Long id;

    @Column (name="user_name")
    private String name;

    private boolean isEnable;

    @OneToMany(mappedBy = "user")
    private List<Sale> sale;

}
