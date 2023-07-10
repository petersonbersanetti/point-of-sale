package com.peterson.pdv.domain.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column (name=" ")
    private String name;

    @Column (name=" ")
    private boolean isEnable;

}
