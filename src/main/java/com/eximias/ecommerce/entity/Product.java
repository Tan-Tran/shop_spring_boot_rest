package com.eximias.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private String origin;
    private int price;
    private String description;
}
