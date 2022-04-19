package com.eximias.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name ="orders_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private Integer quantity;

    private Integer total;

    private String description;

}
