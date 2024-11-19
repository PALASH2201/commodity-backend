package com.palash.commodity.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commodity")
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="category")
    private String category;
    @Column(name="unitPrice")
    private Long unitPrice;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "totalValue")
    private Long totalValue;
}
